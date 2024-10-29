public class Link<E> { // Singly linked list node

  private E element; // Value for this node
  private Link<E> next; // Pointer to next node in list

  // Constructors
  Link(E it, Link<E> nextval) {
    element = it;
    next = nextval;
  }

  Link(Link<E> nextval) {
    next = nextval;
  }

  Link<E> next() {
    return next;
  }

  Link<E> setNext(Link<E> nextval) {
    return next = nextval;
  }

  E element() {
    return element;
  }

  E setElement(E it) {
    return element = it;
  }
} // class Link
