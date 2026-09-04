public class Participant {
    private String name;
    private String teamName;
    private boolean registered;

    // 2-argument constructor
    public Participant(String name, String teamName) {
        this.name = name;
        this.teamName = teamName;
        this.registered = true;
    }

    // 1-argument constructor chaining via this(...)
    public Participant(String name) {
        this(name, "Unassigned");
    }

    public void printStatus() {
        System.out.println(name + " | " + teamName + " | Registered: " + registered);
    }

    public static void main(String[] args) {
        String[] names = {"Ravi", "Meera", "Karthik", "Divya"};
        String[] teamNames = {"ByteBusters", "", "CodeCrafters", ""};

        // Process each participant using a for loop with an if-else check
        for (int i = 0; i < names.length; i++) {
            Participant p;
            if (teamNames[i] == null || teamNames[i].isEmpty()) {
                p = new Participant(names[i]);
            } else {
                p = new Participant(names[i], teamNames[i]);
            }
            p.printStatus();
        }
    }
}