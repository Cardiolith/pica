package common

enum CommonErrors {
    GENERAL_INTERNAL_ERROR(0, "general internal error", true),
    GENERAL_ERROR(1, "general error"),
    MISSING_FIELD(2, "missing required field")

    private long code
    private String description
    private boolean internal

    CommonErrors(long code, String description, boolean internal){
        this.code=code
        this.description=description
        this.internal=internal
    }
}
