package com.starv.micro.goods.mapper.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Root {

    @JsonProperty("_embedded")
    private Embedded embedded;

    public Embedded getEmbedded() {
        return embedded;
    }

}
