package bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.mdeisv2e4.apcc.core.api.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientResponseEntity {
    @SerializedName("success")
    @Expose
    private String success;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("client")
    @Expose
    private ClientEntity clientEntity;

    private int statusCode;
}
