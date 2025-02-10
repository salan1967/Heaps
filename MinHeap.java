package a4;
import java.util.Arrays;
public class MinHeap implements Heap {

  private int size = 0; // number of elements currently in the heap
  private int[] elts;   // heap array
  private int max;      // array declared size

  // ================================================
  // constructors
  // ================================================

  public MinHeap(int umax) { // user defined heap size
    this.max = umax;
    this.elts = new int[umax];
  }

  public MinHeap() { // default heap size is 100
    this.max = 100;
    this.elts = new int[100];
  }

  //==================================================
  // methods we need to grade
  //==================================================

  public int[] getArray() { return this.elts;}

  //=========================================================
  // public methods -- Implement these for the assignment.
  // Note that we want a Min Heap... so the operations
  // getFront and delFront and insert have to compare 
  // for min being at the root  
  //========================================================= 


  public void insert(int p) {
    //Hint: remember to update size.  Also, remember that we skip index 0 in the array.
    /*Your code here */
    this.elts[++size] = p;
    int tmp = size;
    while (this.elts[tmp] < this.elts[tmp / 2]) {
      int temporar = this.elts[tmp];
      this.elts[tmp] = this.elts[tmp / 2];
      this.elts[tmp / 2] = temporar;
    }
  }
  public void delFront () {
    /*Your code here */
    elts[1] = elts[size];
    size--;
    int tmp = 1;
    while (this.elts[tmp] > this.elts[2 * tmp] || this.elts[tmp] > this.elts[(2 * tmp) + 1]) {
      int temporary = this.elts[tmp];
      if (this.elts[2 * tmp] > this.elts[(2 * tmp) + 1]) {
        this.elts[tmp] = this.elts[(2 * tmp) + 1];
        this.elts[(2 * tmp) + 1] = temporary;
      } else {
        this.elts[tmp] = this.elts[(2 * tmp)];
        this.elts[(2 * tmp)] = temporary;


      }
    }

  }
  public int getFront () throws IllegalStateException {
        //Return the element at the front (i.e., the smallest) element in the min-heap.
        //If the min-heap has no elements, throw an IllegalStateException.
      if (empty())
          throw new IllegalStateException();
      else {
          int lesser = elts[1];
          for (int i = 1; i < size; i++) {
            for (int k = i + 1; k < size; k++) {
              if (elts[i] < elts[k]) {
                lesser = elts[i];
                elts[i] = elts[k];
                elts[k] = lesser;
              }
            }
          }
          return lesser;
        }
      }

  public boolean empty () {
        /*Your code here */
        if (size == 0) {
          return true;
        } else
          return false;
      }

  public int size () {
        return this.size;

      }

  public void clear () {
        /*Your code here */
        int[] chan = new int[this.max];
        elts = chan;
        size = 0;
      }

  public void build ( int[] e, int ne){
        //Hint: remember to skip slot 0 in the heap array.
        if (ne > this.max) {
          return;
        }
        this.clear();
        this.size = ne;
        int i = 0;
        int j = 1;
        while (i < this.size) {
          this.elts[j] = e[i];
          i++;
          j++;
        }
        while (ne > 0) {
          int ch = this.elts[ne];
          int chind = ne;
          int parind = ne / 2;
          while (ch < this.elts[parind] && chind != 1) {
            this.elts[chind] = this.elts[parind];
            chind = parind;
            parind = chind / 2;
          }
          this.elts[chind] = ch;
          ne--;
        }

      }

  public int[] sort () {
        // Hint: the smallest element will go in slot 0
        int[] arr2 = new int[size];
        for (int j = 0; j < size; j++) {
          arr2[j] = elts[j + 1];
        }
        Arrays.sort(arr2);
        return arr2;

        // Dummy return statement.  Remove (or move elsewhere) when you implement!
      }
}
