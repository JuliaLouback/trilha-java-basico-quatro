import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public class Banco {
    private static List<Conta> contas = new ArrayList<Conta>();

    public void addConta (Conta conta) {
        contas.add(conta);
    }

    public void listarContas () {
        contas.forEach(System.out::println);
    }

    public void listarClientes () {
        contas.stream()
            .filter(distinctByKey(Conta::getCliente))
            .forEach(conta -> System.out.println(conta.getCliente()));
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}
