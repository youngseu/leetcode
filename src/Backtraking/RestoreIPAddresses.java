package Backtraking;

import java.util.ArrayList;
import java.util.List;

//93 problem
//Restore IP Addresses
//Given a string containing only digits, restore it by returning all possible valid IP address
//combinations.
//Example:
//Input: "25525511135"
//Output: ["255.255.11.135", "255.255.111.35"]
public class RestoreIPAddresses {
    public void backtrak(String ip, List<String> res, int start, String tmp, int count) {
        if (count > 4) return;
        if (count == 4 && start == ip.length()) res.add(tmp);
        for (int i = 1; i < 4; i++) {
            if (start + i > ip.length()) break;
            String s = ip.substring(start, start + i);
            if ((s.startsWith("0") && s.length() > 1) || (i == 3 && Integer.parseInt(s) > 255)) continue;
            backtrak(ip, res, start + i, tmp + s + (count == 3 ? "" : "."), count + 1);
        }
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backtrak(s, res, 0, "", 0);
        return res;
    }
}
