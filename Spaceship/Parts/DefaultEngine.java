package Spaceship.Parts;

// Абстрактный класс-предок всех двигателей

public abstract class DefaultEngine extends SpaceshipPart implements StartStoppable {

    // Поля

    public boolean isOn;
    public int power;

    // Запрос описания объекта
    @Override
    public String toString() {return ("\nEngine's name: " + name +  "\nEngine is running: " + isOn + "\nPower: " + power + "\n");}

    // Конструктор

    public DefaultEngine(String name) {this.name = name;}

    // Запуск двигателя

    @Override
    public void start() {isOn = true;
                        power = 10;}

    // Остановка двигателя

    @Override
    public void stop() {
        power = 0;
        isOn = false;
        }
}
