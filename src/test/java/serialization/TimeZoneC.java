package serialization;

public class TimeZoneC {
    private String fromTimeZone;
    private String dateTime;
    private String toTimeZone;
    private String dstAmbiguity;

    public String getFromTimeZone() {
        return fromTimeZone;
    }

    public void setFromTimeZone(String fromTimeZone) {
        this.fromTimeZone = fromTimeZone;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getToTimeZone() {
        return toTimeZone;
    }

    public void setToTimeZone(String toTimeZone) {
        this.toTimeZone = toTimeZone;
    }

    public String getDstAmbiguity() {
        return dstAmbiguity;
    }

    public void setDstAmbiguity(String dstAmbiguity) {
        this.dstAmbiguity = dstAmbiguity;
    }


}
