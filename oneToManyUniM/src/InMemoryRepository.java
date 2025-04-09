import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryRepository<T> {
    private final Map<Long, T> store = new HashMap<>();
    private final AtomicLong sequence = new AtomicLong(1);

    public interface IdSetter<T> {
        void setId(T entity, Long id);
    }

    public Long save(T entity, IdSetter<T> idSetter) {
        Long id = sequence.getAndIncrement();
        idSetter.setId(entity, id);
        store.put(id, entity);
        return id;
    }

    public Optional<T> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public List<T> findAll() {
        return new ArrayList<>(store.values());
    }

    public void delete(Long id) {
        store.remove(id);
    }

    public void update(Long id, T entity) {
        store.put(id, entity);
    }
}