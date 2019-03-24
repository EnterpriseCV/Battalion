package vo;

/**
 * created by Kimone
 * date 2019/3/24
 */
public class ResultVO {
    private boolean state;
    private String message;

    public ResultVO(){
        this(true,"");
    }
    public ResultVO(boolean state, String message){
        this.state = state;
        this.message = message;
    }
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
