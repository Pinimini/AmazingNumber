package numbers;

public class InvalidParamException extends Exception {
    private int param;

    public InvalidParamException(int param) {
        this.param = param;
    }

    public int getParam() {
        return param;
    }
}
