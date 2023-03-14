package lectures._17.extra;

import java.time.LocalDate;

public class ObjectWithDate {
    private LocalDate date;

    public ObjectWithDate() {
        this.date = LocalDate.now();
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate value) {
        if (this.date.isBefore(value)) {
            this.date = value;
        }
    }

    public void updateDate() {
        this.date = LocalDate.now();
    }
}
