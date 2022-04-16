package bll.validators;

/**
 * @author Dragomir Mihai-Robert, grupa 302210
 * @since Apr 17, 2021
 */
public interface Validator<T> {
    /**
     * Verifica corectitudinea dpdv logic si al db a unor campuri ale unui obiect
     * @param t un obiect generic
     */
    public void validate(T t);
}
