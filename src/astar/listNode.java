/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package astar;

/**
 *
 * @author akshay
 */
public class listNode {
        public node n;
        public int g_score;
        listNode(node n1,int gval)
        {
            n=n1;
            g_score=gval;
        }
        listNode(){}
        public boolean equals(listNode other) 
        {
                return (this.n.num == other.n.num);
        }
}
