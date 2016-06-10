package learn.ds.string.manupulation;

import org.apache.commons.lang3.StringUtils;

public class LexoGreaterSubstring {

    public void execute() {
        // abc -> bc
        // sst -> st
        // ssat -> t
        // dcbdcbx -> dcbx
        // dcbdcbax -> x
        System.out.println(getResult("dcbdcbx"));
    }

    public String getResult(String str) {
        if (StringUtils.isBlank(str)) {
            return "";
        }
        return processString(str);
    }

    // dcbdcbx -> dcbx
    // dcbdcbax -> x
    private String processString(String str) {
        int start = 0;
        int end = 0;
        int maxSize = 0;
        for (int oIndex = 1; oIndex < str.length(); oIndex++) {

            for (int iIndex = 0; iIndex < str.length() - oIndex; iIndex++) {
                if (str.charAt(iIndex + oIndex) < str.charAt(iIndex)) {
                    break;
                } else if ((str.charAt(iIndex + oIndex) > str.charAt(iIndex))) {
                    if (iIndex >= maxSize) {
                        start = oIndex;
                        end = oIndex + iIndex + 1;
                        maxSize = end - start;
                    }
                }

            }

        }

        return str.substring(start, end);
    }
}
