public class DFA {

    public static void main(String[] args) {
        String s = "abb";
        System.out.println(States.accept(s));

        }



    private enum States {
        S0(false), S1(false), S2(false), S3(false), S4(true);
        private final boolean accept;

        States a;
        States b;

        static {
            S0.a = S1;
            S0.b = S2;
            S1.a = S1;
            S1.b = S3;
            S2.b = S2;
            S2.a = S1;
            S3.a = S1;
            S3.b = S4;
            S4.a = S1;
            S4.b = S2;
        }

        States transition(char c) {
            switch (c) {
                case 'a':
                    return this.a;
                case 'b':
                    return this.b;
                default:
                    throw new RuntimeException("Invalid input");
            }
        }

        States(boolean accept) {
            this.accept = accept;
        }

        public static boolean accept(String string) {
            States state = States.S0;
            for (int i = 0; i < string.length(); i++) {
                state = state.transition(string.charAt(i));
            }
            return state.accept;
        }
    }
}


