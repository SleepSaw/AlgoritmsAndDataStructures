package dataStructures.doublyLinkedList;

import java.util.ArrayList;
import java.util.List;
/**
 * Класс DoublyLinkedList представляет двусвязный список.
 * @author Sleptsov Daniil
 */
public class DoublyLinkedList {
    private Node rootNode;
    private Node lastNode;
    private int length;

    /**
     * Конструктор по умолчанию. Создает пустой список.
     */
    public DoublyLinkedList() {
    }

    /**
     * Конструктор, принимающий первый узел списка. Создает список с одним элементом.
     *
     * @param rootNode первый узел списка
     */
    public DoublyLinkedList(Node rootNode) {
        this.rootNode = rootNode;
    }

    /**
     * Возвращает длину списка.
     *
     * @return длина списка
     */
    public int length(){
        return length;
    }

    /**
     * Возвращает первый узел списка.
     *
     * @return первый узел списка
     */
    public Node root(){
        return rootNode;
    }

    /**
     * Возвращает последний узел списка.
     *
     * @return последний узел списка
     */
    public Node last(){
        return lastNode;
    }

    /**
     * Проверяет, пуст ли список.
     *
     * @return true, если список пуст, иначе false
     */
    public boolean isEmpty(){
        return length == 0;
    }

    /**
     * Добавляет узел в конец списка.
     *
     * @param addedNode добавляемый узел
     */
    public void add(Node addedNode){
        if (isEmpty()){
            rootNode = addedNode;
            lastNode = rootNode;
        }
        else {
            lastNode.next = addedNode;
            addedNode.prev = lastNode;
            lastNode = addedNode;
        }
        length++;
    }

    /**
     * Удаляет указанный узел из списка.
     *
     * @param nodeForDelete узел, который требуется удалить
     */
    public void delete(Node nodeForDelete){
        Node node = rootNode;
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        if (rootNode == nodeForDelete) {
            rootNode = rootNode.next;
            rootNode.prev = null;
            length--;
            return;
        }
        while (node != lastNode){
            if (node == nodeForDelete){
                node.prev.next = node.next;
                node.next.prev = node.prev;
                break;
            }
            node = node.next;
        }
        length--;
    }

    /**
     * Удаляет узел по указанному индексу.
     *
     * @param index индекс узла, который требуется удалить
     */
    public void delete(int index){
        Node node = rootNode;
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        if (index >= length) {
            System.out.println("Index out from bound");
            return;
        }
        if (index == 0) {
            rootNode = rootNode.next;
            length--;
            return;
        }
        for (int i = 1; i < index; i++) {
            node = node.next;
        }
        node.next = node.next.next;
        length--;
    }

    /**
     * Возвращает узел по указанному индексу.
     *
     * @param index индекс требуемого узла
     * @return узел по указанному индексу
     */
    public Node get(int index) {
        Node node = rootNode;
        if (isEmpty()) {
            System.out.println("List is empty");
        }
        if (index >= length) {
            System.out.println("Index out from bound");
            return null;
        }
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    /**
     * Возвращает список всех узлов в виде списка.
     *
     * @return список всех узлов
     */
    public List<Node> getAll(){
        Node node = rootNode;
        List<Node> list = new ArrayList<>();
        if (rootNode == null) {
            System.out.println("List is empty");
            return null;
        }
        while (node.next != null){
            list.add(node);
            node = node.next;
        }
        list.add(node);
        return list;
    }
}

/**
 * Класс Node представляет узел двусвязного списка.
 */
class Node {
    int value;
    Node next;
    Node prev;

    /**
     * Конструктор по умолчанию. Создает узел с пустыми значениями.
     */
    public Node() {
    }

    /**
     * Конструктор, принимающий значение узла.
     *
     * @param value значение узла
     */
    public Node(int value) {
        this.value = value;
    }

    /**
     * Конструктор, принимающий значение узла, ссылку на следующий узел и ссылку на предыдущий узел.
     *
     * @param value значение узла
     * @param next ссылка на следующий узел
     * @param prev ссылка на предыдущий узел
     */
    public Node(int value, Node next, Node prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    /**
     * Возвращает строковое представление узла.
     *
     * @return строковое представление узла
     */
    @Override
    public String toString() {
        return "Node: " + "value= " + value +";";
    }
}

