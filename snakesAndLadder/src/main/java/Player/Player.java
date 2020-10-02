package Player;

import java.util.Objects;

public class Player {
    private String name;
    private int uuid;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return getUuid() == player.getUuid() &&
                getName().equals(player.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getUuid());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }
}
