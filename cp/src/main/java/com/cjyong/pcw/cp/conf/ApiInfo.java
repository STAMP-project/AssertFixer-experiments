package com.cjyong.pcw.cp.conf;

public interface ApiInfo {
    //--------------------------User relative interface
    String userApi = "/api/v1/user";
    String login = "/login";
    String updateUserInfo = "/update";

    //-------------------------DailyActivity relative interface
    String activityApi = "/api/v1/activity";
    String uploadActivity = "/upload";
    String getOneDA = "/getOneDA";
    String addCommentsToDA = "/addCommentsToDA";
    String getAllDA = "/getAllDA";
    String delOneSelf = "/delete";

    //------------------------DailySentence relative interface
    String dailySentenceApi = "/api/v1/dailySentence";
    String uploadDailySentence = "/upload";
    String getOneDS = "/getOneDS";
    String addCommentsToDS = "/addCommentsToDS";
    String getAllDS = "/getAllDS";
    String indexApi = "/indexInfo";

    //----------------------Album relative interface
    String ablumApi = "/api/v1/ablum";
    String createAblum = "/create";
    String getOneAblum = "/getOneAblum";
    String addCommentsToAB = "/addCommentsToAB";
    String getAllAblums = "/getAllAblums";

    //----------------------Blog relative interface
    String blogApi = "/api/v1/blog";
    String getIndexCount = "/incAndGetIndex";
    String getTypeCount = "/incAndGetType";
    String getPaperCount = "/incAndGetPaper";

    //----------------------Github relative interface
    String gitApi = "/api/v1/git";
    String updatePersonalNote = "pn";
}
