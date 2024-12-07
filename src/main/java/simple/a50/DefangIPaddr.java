package simple.a50;

public class DefangIPaddr {
    public String defangIPaddr1(String address) {
        return address.replace(".", "[.]");
    }

    public String defangIPaddr(String address) {
        char[] result = new char[address.length() + 6];
        int index = 0;
        for (int i = 0; i < address.length(); i++) {
            char c = address.charAt(i);
            if (c != '.') {
                result[index] = c;
                index++;
            } else {
                result[index] = '[';
                result[index + 1] = '.';
                result[index + 2] = ']';
                index = index + 3;
            }
        }
        return new String(result);
    }
}

