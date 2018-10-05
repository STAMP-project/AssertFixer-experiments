package ru.job4j.pseudo;
/**
 * @author Egorova Svetlana (s.sosenkova@gmail.com)
 *
 * @version $Id$
 *
 * @since 0.1
 *
 */
    public class Square implements Shape {
        @Override
        public String draw() {
            StringBuilder pic = new StringBuilder();
            pic.append(" ++++" + "\n");
            pic.append("+    +" + "\n");
            pic.append("+    +" + "\n");
            pic.append(" ++++" + "\n");
            return pic.toString();
        }
    }