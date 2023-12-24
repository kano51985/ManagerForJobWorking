package com.sana.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Assets {
    private Integer asset_id;
    private Integer department_id;
    private String asset_name;
}
