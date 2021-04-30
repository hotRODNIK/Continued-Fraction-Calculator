public class ArrayList {
    private String[] list;

    public ArrayList(){
        list = new String[5];
    }

    // Adds a value to the end of the ArrayList
    public void append(long value){
        // Boolean flag
        boolean isAdded = false;

        // Starting at the front, find the first nonempty element
        for (int i = 0; i < list.length && !isAdded; i++){
            if (list[i] == null){
                list[i] = Long.toString(value);
                isAdded = true;
            }
        }

        // If nothing was added we need to grow the list
        if (!isAdded){
            grow();

            for (int i = 0; i < list.length && !isAdded; i++){
                if (list[i] == null){
                    list[i] = Long.toString(value);
                    isAdded = true;
                }
            }
        }
    }

    // Grow method which when called grows the list by doubling its size
    private void grow(){
        String[] newList = new String[list.length * 2];

        for (int i = 0; i < list.length; i++){
            newList[i] = list[i];
        }

        list = newList;
    }

    // Overridden toString method, which properly formats the stored coefficients into the proper tuple notation
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("[").append(list[0]).append(";");

        for (int i = 1; i < list.length; i++){
            if (list[i] != null){
                s.append(list[i]).append(",");
            }
        }

        s.deleteCharAt(s.length() - 1);
        s.append("]");

        return s.toString();
    }
}
