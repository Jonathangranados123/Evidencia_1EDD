package Evidencia_3.utils;
/**
 * Clase que representa un nodo en un árbol binario.
 *
 * @param <E> Tipo de datos que almacena el nodo.
 */
public class BTNode<E> {

    private E data;
    private BTNode<E> left, right;

    /**
     * Constructor que inicializa un nodo con datos iniciales, un nodo izquierdo y un nodo derecho.
     *
     * @param initialData   Datos iniciales del nodo.
     * @param initialLeft   Nodo izquierdo.
     * @param initialRight  Nodo derecho.
     */
    public BTNode(E initialData, BTNode<E> initialLeft, BTNode<E> initialRight) {
        data = initialData;
        left = initialLeft;
        right = initialRight;
    }

    /**
     * Obtiene los datos almacenados en el nodo.
     *
     * @return Datos almacenados en el nodo.
     */
    public E getData() {
        return data;
    }
    /**
     * Obtiene el nodo izquierdo.
     *
     * @return Nodo izquierdo.
     */
    public BTNode<E> getLeft() {
        return left;
    }

    /**
     * Obtiene los datos del nodo más a la izquierda en el subárbol.
     *
     * @return Datos del nodo más a la izquierda.
     */
    public E getLeftmostData() {
        if (left == null)
            return data;
        else
            return left.getLeftmostData();
    }

    /**
     * Obtiene el nodo derecho.
     *
     * @return Nodo derecho.
     */
    public BTNode<E> getRight() {
        return right;
    }

    /**
     * Obtiene los datos del nodo más a la derecha en el subárbol.
     *
     * @return Datos del nodo más a la derecha.
     */
    public E getRightmostData() {
        if (left == null)
            return data;
        else
            return left.getRightmostData();
    }

    /**
     * Realiza una impresión en orden del árbol.
     */
    public void inorderPrint() {
        if (left != null)
            left.inorderPrint();
        System.out.println(data);
        if (right != null)
            right.inorderPrint();
    }

    /**
     * Verifica si el nodo es una hoja.
     *
     * @return true si el nodo es una hoja, false en caso contrario.
     */
    public boolean isLeaf() {
        return (left == null) && (right == null);
    }

    /**
     * Realiza una impresión en preorden del árbol.
     */
    public void preorderPrint() {
        System.out.println(data);
        if (left != null)
            left.preorderPrint();
        if (right != null)
            right.preorderPrint();
    }

    /**
     * Realiza una impresión en postorden del árbol.
     */
    public void postorderPrint() {
        if (left != null)
            left.postorderPrint();
        if (right != null)
            right.postorderPrint();
        System.out.println(data);
    }

    /**
     * Realiza una impresión del árbol con indentación según la profundidad.
     *
     * @param depth Profundidad actual del nodo en el árbol.
     */
    public void print(int depth) {
        int i;

        for (i = 1; i <= depth; i++)
            System.out.print("    ");
        System.out.println(data);

        if (left != null)
            left.print(depth + 1);
        else if (right != null) {
            for (i = 1; i <= depth + 1; i++)
                System.out.print("    ");
            System.out.println("--");
        }

        if (right != null)
            right.print(depth + 1);
        else if (left != null) {
            for (i = 1; i <= depth + 1; i++)
                System.out.print("    ");
            System.out.println("--");
        }
    }

    /**
     * Elimina el nodo más a la izquierda en el subárbol.
     *
     * @return El nodo resultante después de eliminar el nodo más a la izquierda.
     */
    public BTNode<E> removeLeftmost() {
        if (left == null)
            return right;
        else {
            left = left.removeLeftmost();
            return this;
        }
    }

    /**
     * Elimina el nodo más a la derecha en el subárbol.
     *
     * @return El nodo resultante después de eliminar el nodo más a la derecha.
     */
    public BTNode<E>  removeRightmost() {
        if (right == null)
            return left;
        else {
            right = right.removeRightmost();
            return this;
        }
    }
    /**
     * Establece nuevos datos para el nodo.
     *
     * @param newData Nuevos datos a establecer.
     */
    public void setData(E newData) {
        data = newData;
    }

    /**
     * Establece un nuevo nodo izquierdo.
     *
     * @param newLeft Nuevo nodo izquierdo.
     */
    public void setLeft(BTNode<E> newLeft) {
        left = newLeft;
    }

    /**
     * Establece un nuevo nodo derecho.
     *
     * @param newRight Nuevo nodo derecho.
     */
    public void setRight(BTNode<E> newRight) {
        right = newRight;
    }

/**
 * Realiza una copia del árbol.
 *
 * @param source Nodo raíz del árbol a copiar.
 * @param <E>    Tipo de datos del árbol.
 * @return Copia del árbol.
 */
public static <E> BTNode<E> treeCopy(BTNode<E> source) {
    BTNode<E> leftCopy, rightCopy;

    if (source == null)
        return null;
    else {
        leftCopy = treeCopy(source.left);
        rightCopy = treeCopy(source.right);
        return new BTNode<E>(source.data, leftCopy, rightCopy);
    }
}

    /**
     * Obtiene el tamaño del árbol.
     *
     * @param root Raíz del árbol.
     * @param <E>  Tipo de datos del árbol.
     * @return Tamaño del árbol.
     */
    public static <E> long treeSize(BTNode<E> root) {
        if (root == null)
            return 0;
        else
            return 1 + treeSize(root.left) + treeSize(root.right);
}
}

