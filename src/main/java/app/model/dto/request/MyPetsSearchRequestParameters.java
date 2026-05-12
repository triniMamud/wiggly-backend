package app.model.dto.request;

import lombok.Data;

@Data
public class MyPetsSearchRequestParameters {

    private String gender;
    private Integer age;
    private String location;
    private String size;
    private Boolean type;
}
