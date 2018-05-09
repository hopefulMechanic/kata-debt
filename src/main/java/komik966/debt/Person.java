package komik966.debt;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import java.util.List;

public class Person {

    private final DebtRepository debtRepository;

    private final String name;
    private List<Integer> debtsList;

    @Inject
    public Person(DebtRepository debtRepository, @Assisted String name) {
        this.debtRepository = debtRepository;
        this.name = name;
    }

    public void borrow(Person from, Integer moneyAmount) {
        debtRepository.registerDebt(this, from, moneyAmount);
    }

    public Integer getDebt(Person lender) {
        return debtRepository.fetchDebt(this, lender);
    }

    public void listDebts() {
        debtsList = debtRepository.listDebts(this);
    }

    public List<Integer> getDebtsList() {
        return debtsList;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
