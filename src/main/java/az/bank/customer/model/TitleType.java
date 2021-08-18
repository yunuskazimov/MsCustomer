package az.bank.customer.model;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;
import java.util.Locale;

public enum TitleType implements Serializable {
    MR, MRS, MISS, MS, OTHER;

    @JsonValue
    public String toLower() {
        return this.toString().toLowerCase(Locale.ENGLISH);
    }
}
