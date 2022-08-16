package com.whereigo.enumSave;

import org.springframework.http.HttpMethod;

public enum ApiUrl {
    GET_ALL_ATTRACTIONS(1, "attraction",HttpMethod.GET,"https://gis.taiwan.net.tw/XMLReleaseALL_public/scenic_spot_C_f.json");

    private Integer id;
	private String type;
	private HttpMethod method;
	private String url;
	
	private ApiUrl(Integer id, String type, HttpMethod method, String url) {
		this.id = id;
		this.type = type;
		this.method =method;
		this.url = url;
	}

	public Integer getId() {
		return id;
	}

	public String getType() {
		return type;
	}
	
	public HttpMethod getMethod() {
		return method;
	}

	public String getUrl() {
		return url;
	}
}
