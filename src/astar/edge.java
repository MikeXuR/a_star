/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package astar;

/**
 *
 * @author akshay
 */
public class edge {
    public int weight;
    public node node1;
    public node node2;
    edge(int w,node n1,node n2)
    {
        weight=w;
        node1=n1;
        node2=n2;
    }
    public boolean equals(edge other) {
        return ((this.node1 == other.node1)&&(this.node2==other.node2));
    }
}
