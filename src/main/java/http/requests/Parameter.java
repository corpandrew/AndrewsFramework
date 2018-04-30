package http.requests;

@Deprecated
class Parameter {

    private APIParam apiParam;
    private String value;

    public enum APIParam {
        SEASON("season_slug"), TEAM("team_slug"), LEAGUE("league_slug"),
        ROUND("round_slug"), POSITION("position"), MATCH("match_slug"),
        TEAM_1("team_1"), TEAM_2("team_2"), TEAM_IDENTIFIER("team_identifiera");

        String APIParamValue;

        APIParam(String APIParamValue) {
            this.APIParamValue = APIParamValue;
        }

        public String getAPIParamValue() {
            return APIParamValue;
        }
    }

    Parameter(APIParam param, String value) {
        this.apiParam = param;
        this.value = value;
    }

    APIParam getAPIParam() {
        return apiParam;
    }

    String getValue() {
        return value;
    }
}
