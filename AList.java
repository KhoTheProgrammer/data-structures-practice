/** Array-based list implementation */
class AList<E> implements List<E> {

  private static final int defaultSize = 10; // Default size
  private int maxSize; // Maximum size of list
  private int listSize; // Number of list items now
  private int curr; // Position current element
  private E[] listArray; // Array holding list elements

  /** Constructors */
  /** Create a list with the default capacity. */
  AList() {
    this(defaultSize);
  }

  /** Create a new list object.
@param size Max number of elements list can contain. */
  @SuppressWarnings("unchecked") // Generic array allocation
  AList(int size) {
    maxSize = size;
    listSize = curr = 0;
    listArray = (E[]) new Object[size]; // Create listArray
  }

  public void clear() { // Reinitialize the list
    listSize = curr = 0;
  } // Simply reinitialize values

  /** Insert "it" at current position */
  public void insert(E it) {
    assert listSize < maxSize : "List capacity exceeded";
    for (
      int i = listSize;
      i > curr;
      i--
    ) listArray[i] = listArray[i - 1]; // Shift elements up // to make room
    listArray[curr] = it;
    listSize++; // Increment list size
  }

  public void append(E it) { // Append "it"
    assert listSize < maxSize : "List capacity exceeded";
    listArray[listSize++] = it;
  }

  public void moveToStart() {
    curr = 0;
  } // Reset position

  // Remove and return the current element.
  public E remove() {
    if (
      (curr < 0) || (curr >= listSize)
    ) return null; // No current element
    E it = listArray[curr]; // Copy the element
    for (
      int i = curr;
      i < listSize - 1;
      i++
    ) listArray[i] = listArray[i + 1]; // Shift them down
    listSize--; // Decrement size
    return it;
  }

  public void moveToEnd() {
    curr = listSize;
  } // Reset

  public void prev() {
    if (curr != 0) curr--;
  } // Back up

  public void next() {
    if (curr < listSize) curr++;
  } // Next

  // Return list size
  public int length() {
    return listSize;
  }

  public int currPos() { // Return current position
    return curr;
  }

  // Set current list position to "pos"
  public void moveToPos(int pos) {
    assert (pos >= 0) && (pos <= listSize) : "Pos out of range";
    curr = pos;
  }

  public E getValue() { // Return current element
    assert (curr >= 0) && (curr < listSize) : "No current element";
    return listArray[curr];
  }
}
