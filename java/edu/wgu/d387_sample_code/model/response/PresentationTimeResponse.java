package edu.wgu.d387_sample_code.model.response;

public class PresentationTimeResponse {
    private String et;
    private String mt;
    private String utc;
    private String message;

    public PresentationTimeResponse() {}

    public PresentationTimeResponse(String et, String mt, String utc, String message) {
        this.et = et;
        this.mt = mt;
        this.utc = utc;
        this.message = message;
    }

    public String getEt() { return et; }
    public void setEt(String et) { this.et = et; }

    public String getMt() { return mt; }
    public void setMt(String mt) { this.mt = mt; }

    public String getUtc() { return utc; }
    public void setUtc(String utc) { this.utc = utc; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
