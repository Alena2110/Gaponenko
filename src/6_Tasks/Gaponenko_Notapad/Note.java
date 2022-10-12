import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Note implements Serializable {

    private String topic;//тема заметки
    private LocalDate date;//дата создания заметки
    private String email;//электронный адрес заметки
    private String message;//сообщение

    public Note(String topic, String email, String message) {
        this.topic = topic;
        this.date = LocalDate.now();
        this.email = email;
        this.message = message;
    }

    public String getTopic() {
        return topic;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getEmail() {
        return email;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Тема: " + topic + "; дата создания: " + date + "; e-mail: " + email + "; сообщение: " + message + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return Objects.equals(topic, note.topic) && Objects.equals(date, note.date) && Objects.equals(email, note.email)
                && Objects.equals(message, note.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topic, date, email, message);
    }
}
