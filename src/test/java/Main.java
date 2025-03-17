class Main {
    public native void testMethod();

    public static void main(String[] args) {
        final Main mainObject = new Main();
        mainObject.testMethod();
    }
}