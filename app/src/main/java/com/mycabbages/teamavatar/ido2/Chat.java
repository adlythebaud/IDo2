package com.mycabbages.teamavatar.ido2;

import org.w3c.dom.Text;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

/**
 * Created by Preston on 11/17/2017.
 */

public class Chat {
    Vector<TextMessage> textMessages;
    Queue<SnapMessage> snapMessages;

    Chat() {
        textMessages = new Stack<TextMessage>();
        snapMessages = new ArrayDeque<SnapMessage>();
    }
}
