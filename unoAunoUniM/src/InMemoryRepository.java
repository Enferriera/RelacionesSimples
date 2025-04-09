import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryRepository<T> {
    private final Map<Long, T> dataStore = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public interface IdSetter<T> {
        void setId(T entity, Long id);
    }

    public Long save(T entity, IdSetter<T> setter) {
        Long id = idGenerator.getAndIncrement();
        setter.setId(entity, id);
        dataStore.put(id, entity);
        return id;
    }

    public Optional<T> findById(Long id) {
        return Optional.ofNullable(dataStore.get(id));
    }

    public List<T> findAll() {
        return new ArrayList<>(dataStore.values());
    }
}
