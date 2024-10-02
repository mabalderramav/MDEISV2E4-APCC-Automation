package bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.mdeisv2e4.apcc.ui.pages.clients;

public enum ClientFormFields {
    CODE("code"),
    NAME("name"),
    CI_NIT("ciNit"),
    DOCUMENT_TYPE("documentType"),
    EMAIL("email");

    private final String fieldName;

    ClientFormFields(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}
