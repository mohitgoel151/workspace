package learn.distributesSystems.throttling;

import java.util.concurrent.TimeUnit;

/**
 * 
 * 
 * https://en.wikipedia.org/wiki/Token_bucket
 * Traffic policing and traffic shaping are commonly used to protect the network against excess or excessively bursty traffic
 * Support :  Average Rate & Burst Rate
 * 
 * Good Read : http://crackingjavainterviews.blogspot.in/2013/06/what-do-you-understand-by-token-bucket.html
 * Complete Code: https://github.com/bbeck/token-bucket
 * 
 *
 */
public class TokenBucket {
	
	private final long capacity;
	  private final RefillStrategy refillStrategy;
	  private final SleepStrategy sleepStrategy;
	  private long size;
	  
	  public TokenBucket(long capacity, long initialTokens, RefillStrategy refillStrategy, SleepStrategy sleepStrategy) {
		  this.capacity = capacity;
		    this.refillStrategy = refillStrategy;
		    this.sleepStrategy = sleepStrategy;
		    this.size = initialTokens;
		  
	}
	
	  /**
	   * Returns the current number of tokens in the bucket.  If the bucket is empty then this method will return 0.
	   *
	   * @return The current number of tokens in the bucket.
	   */
	  //@Override
	  public synchronized long getNumTokens()
	  {
	    // Give the refill strategy a chance to add tokens if it needs to so that we have an accurate
	    // count.
	    refill(refillStrategy.refill());

	    return size;
	  }

	  /**
	  * Returns the amount of time in the specified time unit until the next group of tokens can be added to the token
	  * bucket.
	  *
	  * @see org.isomorphism.util.TokenBucket.RefillStrategy#getDurationUntilNextRefill(java.util.concurrent.TimeUnit)
	  * @param unit The time unit to express the return value in.
	  * @return The amount of time until the next group of tokens can be added to the token bucket.
	  */
	  //@Override
	  public long getDurationUntilNextRefill(TimeUnit unit) throws UnsupportedOperationException
	  {
	    return refillStrategy.getDurationUntilNextRefill(unit);
	  }

	  /**
	   * Attempt to consume a single token from the bucket.  If it was consumed then {@code true} is returned, otherwise
	   * {@code false} is returned.
	   *
	   * @return {@code true} if a token was consumed, {@code false} otherwise.
	   */
	  public boolean tryConsume()
	  {
	    return tryConsume(1);
	  }

	  /**
	   * Attempt to consume a specified number of tokens from the bucket.  If the tokens were consumed then {@code true}
	   * is returned, otherwise {@code false} is returned.
	   *
	   * @param numTokens The number of tokens to consume from the bucket, must be a positive number.
	   * @return {@code true} if the tokens were consumed, {@code false} otherwise.
	   */
	  public synchronized boolean tryConsume(long numTokens)
	  {
	    //checkArgument(numTokens > 0, "Number of tokens to consume must be positive");
	    //checkArgument(numTokens <= capacity, "Number of tokens to consume must be less than the capacity of the bucket.");

	    refill(refillStrategy.refill());

	    // Now try to consume some tokens
	    if (numTokens <= size) {
	      size -= numTokens;
	      return true;
	    }

	    return false;
	  }

	  /**
	   * Consume a single token from the bucket.  If no token is currently available then this method will block until a
	   * token becomes available.
	   */
	  public void consume()
	  {
	    consume(1);
	  }

	  /**
	   * Consumes multiple tokens from the bucket.  If enough tokens are not currently available then this method will block
	   * until
	   *
	   * @param numTokens The number of tokens to consume from teh bucket, must be a positive number.
	   */
	  public void consume(long numTokens)
	  {
	    while (true) {
	      if (tryConsume(numTokens)) {
	        break;
	      }

	      sleepStrategy.sleep();
	    }
	  }

	  /**
	   * Refills the bucket with the specified number of tokens.  If the bucket is currently full or near capacity then
	   * fewer than {@code numTokens} may be added.
	   *
	   * @param numTokens The number of tokens to add to the bucket.
	   */
	  public synchronized void refill(long numTokens)
	  {
	    long newTokens = Math.min(capacity, Math.max(0, numTokens));
	    size = Math.max(0, Math.min(size + newTokens, capacity));
	  }

	  
	  static interface RefillStrategy
	  {
	    /**
	     * Returns the number of tokens to add to the token bucket.
	     *
	     * @return The number of tokens to add to the token bucket.
	     */
	    long refill();

	    /**
	     * Returns the amount of time in the specified time unit until the next group of tokens can be added to the token
	     * bucket.  Please note, depending on the {@code SleepStrategy} used by the token bucket, tokens may not actually
	     * be added until much after the returned duration.  If for some reason the implementation of
	     * {@code RefillStrategy} doesn't support knowing when the next batch of tokens will be added, then an
	     * {@code UnsupportedOperationException} may be thrown.  Lastly, if the duration until the next time tokens will
	     * be added to the token bucket is less than a single unit of the passed in time unit then this method will
	     * return 0.
	     *
	     * @param unit The time unit to express the return value in.
	     * @return The amount of time until the next group of tokens can be added to the token bucket.
	     */
	    long getDurationUntilNextRefill(TimeUnit unit) throws UnsupportedOperationException;
	  }

	  /** Encapsulation of a strategy for relinquishing control of the CPU. */
	  static interface SleepStrategy
	  {
	    /**
	     * Sleep for a short period of time to allow other threads and system processes to execute.
	     */
	    void sleep();
	  }

}
