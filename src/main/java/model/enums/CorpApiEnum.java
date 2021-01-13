package model.enums;

import java.util.Map;

public enum CorpApiEnum {
    GET_TOKEN(1, "url1", "access_token", "获取access_token"){
        @Override
        protected Boolean paramsVerify(Map<String, Object> params) {
            return null;
        }

        @Override
        protected Boolean bodiedVerify(Map<String, Object> bodies) {
            return null;
        }
    };
    private Integer id;
    private String url;
    private String resultField;
    private String description;

    CorpApiEnum(Integer id, String url, String resultField, String description){
        this.id=id;
        this.url=url;
        this.resultField=resultField;
        this.description=description;
    }

    protected abstract Boolean paramsVerify(Map<String, Object> params);

    protected abstract Boolean bodiedVerify(Map<String,Object> bodies);

    public <T> T doRequest(Map<String, Object> params, Map<String,Object> bodies, Class<T> resultType){
        return null;
    }
}
