package dataStructures.singlyLinkedList;

import java.util.ArrayList;
import java.util.List;
/**
 * Класс MySinglyLinkedList представляет односвязный список
 * @author Sleptsov Daniil
 */
public class MySinglyLinkedList {
    private Node rootNode;
    private Node lastNode;
    private int length;

    /**
     * Конструктор по умолчанию. Создает пустой список.
     */
    public MySinglyLinkedList() {
        this.rootNode = null;
        this.lastNode = null;
    }

    /**
     * Конструктор, принимающий первый узел списка. Создает список с одним элементом.
     *
     * @param rootNode первый узел списка
     */
    public MySinglyLinkedList(Node rootNode) {
        this.rootNode = rootNode;
        this.lastNode = rootNode;
        length++;
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
        }
        if (rootNode == nodeForDelete) {
            rootNode = rootNode.next;
        }
        while (node != lastNode){
            if (node.next == nodeForDelete){
                node.next = node.next.next;
                break;
            }
            node = node.next;
            if (node == lastNode) {
                System.out.println("Node was not found");
            }
        }
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
            return;
        }
        for (int i = 1; i < index; i++) {
            node = node.next;
        }
        node.next = node.next.next;
    }

    /**
     * Возвращает узел поуказанному индексу.
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
 * Класс Node представляет узел односвязного списка.
 */
class Node{
    int value;
    Node next;

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
     * Конструктор, принимающий значение узла и ссылку на следующий узел.
     *
     * @param value значение узла
     * @param next ссылка на следующий узел
     */
    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
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


