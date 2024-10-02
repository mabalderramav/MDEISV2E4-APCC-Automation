package bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.mdeisv2e4.apcc.core.api.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientEntity {
    @SerializedName("code")
    @Expose
    private String code;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("ciNit")
    @Expose
    private String ciNit;

    @SerializedName("documentType")
    @Expose
    private String documentType;

    @SerializedName("email")
    @Expose
    private String email;
}
