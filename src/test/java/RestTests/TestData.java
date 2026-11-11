package RestTests;

public class TestData {
    public static String getTimeZoneData(){
        return """
                {
                  "fromTimeZone": "Africa/Cairo",
                  "dateTime": "2026-07-31 19:25:00",
                  "toTimeZone": "America/Los_Angeles",
                  "dstAmbiguity": ""
                }
                """;
    }
    public static String getTimeZoneDataCorrelation(String s1,String s3){
        return """
                {
                  "fromTimeZone": "%s",
                  "dateTime": "%s",
                  "toTimeZone": "America/Los_Angeles",
                  "dstAmbiguity": ""
                }
                """.formatted(s1,s3);

    }
}
