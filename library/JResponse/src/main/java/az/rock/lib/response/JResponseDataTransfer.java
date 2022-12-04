package az.rock.lib.response;

import az.rock.lib.JDataTransfer;
import az.rock.lib.JHeader;
import az.rock.lib.response.success.JSuccessDataResponse;

import javax.management.JMRuntimeException;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class JResponseDataTransfer<D> extends JDataTransfer<D> {
    private final static JResponseDataTransfer<?> EMPTY = new JResponseDataTransfer<>(null,Boolean.FALSE);

    private final Boolean success;
    private final String message;

    public JResponseDataTransfer(D data, Boolean success, String message) {
        super(data);
        this.success = success;
        this.message = message;
    }

    public JResponseDataTransfer(JHeader header, D data, Boolean success, String message) {
        super(header, data);
        this.success = success;
        this.message = message;
    }

    public JResponseDataTransfer(D data,Boolean success) {
        super(data);
        this.success = success;
        this.message = null;
    }

    public JResponseDataTransfer(JHeader header, D data,Boolean success) {
        super(header, data);
        this.success = success;
        this.message = null;
    }

    public D get() {
        if (Objects.isNull(super.getData()))
            throw new JMRuntimeException("No value present");
        return super.getData();
    }

    public void ifPresent(Consumer<? super D> action) {
        if (!Objects.isNull(super.getData())) {
            action.accept(super.getData());
        }
    }

    public void ifPresentOrElse(Consumer<? super D> action, Runnable emptyAction) {
        if (!Objects.isNull(super.getData())) action.accept(super.getData());
        else emptyAction.run();
    }

    public boolean isPresent() {
        return !Objects.isNull(super.getData());
    }

    public JResponseDataTransfer<D> filter(Predicate<? super D> predicate) {
        Objects.requireNonNull(predicate);
        if (!isPresent()) {
            return this;
        } else {
            return predicate.test(super.getData()) ? this : JResponseDataTransfer.EMPTY();
        }
    }

    public static<D> JResponseDataTransfer<D> EMPTY() {
        @SuppressWarnings("unchecked")
        JResponseDataTransfer<D> object = (JResponseDataTransfer<D>) EMPTY;
        return object;
    }

    public static <D> JResponseDataTransfer<D> of(D data) {
        return new JResponseDataTransfer<>(Objects.requireNonNull(data),Boolean.TRUE);
    }

    public <U> JResponseDataTransfer<U> map(Function<? super D, ? extends U> mapper) {
        Objects.requireNonNull(mapper);
        if (!isPresent()) return EMPTY();
        else return JResponseDataTransfer.ofNullable(mapper.apply(super.getData()));

    }

    @SuppressWarnings("unchecked")
    public static <D> JResponseDataTransfer<D> ofNullable(D value) {
        return value == null ? (JResponseDataTransfer<D>) EMPTY : new JResponseDataTransfer<>(value,Boolean.TRUE);
    }

    public JResponseDataTransfer<D> or(Supplier<? extends JResponseDataTransfer<? extends D>> supplier) {
        Objects.requireNonNull(supplier);
        if (isPresent()) return this;
        else {
            @SuppressWarnings("unchecked")
            JResponseDataTransfer<D> r = (JResponseDataTransfer<D>) supplier.get();
            return Objects.requireNonNull(r);
        }
    }
}
