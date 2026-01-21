package model;

public class PartnerData {
    private String operatorName;
    private String email;
    private String civility;
    private String contactName;
    private String phone;

    public String getOperatorName() {
        return operatorName;
    }

    public String getEmail() {
        return email;
    }

    public String getCivility() {
        return civility;
    }

    public String getContactName() {
        return contactName;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "\n{\n" +
                " operatorName ='" + operatorName + '\'' +
                ",\n email ='" + email + '\'' +
                ",\n civility ='" + civility + '\'' +
                ",\n contactName ='" + contactName + '\'' +
                ",\n phone ='" + phone + '\'' +
                "\n}\n";
    }
}
