/* amodeus - Copyright (c) 2018, ETH Zurich, Institute for Dynamic Systems and Control */
package ch.ethz.idsc.amodeus.dispatcher.shared;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import ch.ethz.idsc.amodeus.util.math.GlobalAssert;

/** Object containing list of shared Courses (pickup, dropoff, rebalance) planned
 * for an RoboTaxi. If the menu */
public class SharedMenu {
    /** Unmodifiable List of Shared Courses */
    private final List<SharedCourse> roboTaxiMenu;

    /** Creates a Shared Menu which is consistent in itself (e.g. no coureses appear twice, for each request it is secured that the dropoff happens after the pickup
     * 
     * @param list
     * @return */
    public static SharedMenu of(List<SharedCourse> list) {
        GlobalAssert.that(SharedCourseListUtils.consistencyCheck(list));
        return new SharedMenu(list);
    }

    public static SharedMenu empty() {
        return new SharedMenu(null);
    }
    private SharedMenu(List<SharedCourse> list) {
        roboTaxiMenu = Collections.unmodifiableList((Objects.isNull(list)) ? new ArrayList<>() : list);
    }

    /** Two ways how to get the Courses in the Menu:
     * this function returns an unmodifiable view of the menu.
     * 
     * @return */
    public List<SharedCourse> getRoboTaxiMenu() {
        return roboTaxiMenu;
    }

    /** Two ways how to get the Courses in the Menu:
     * this function returns an deep copy of the courses in the menu.
     * 
     * @return */
    public List<SharedCourse> getModifiableCopyOfMenu() {
        return SharedCourseListUtils.copy(roboTaxiMenu);
    }

    /** Two exeptions for convinience might be removed and all the Functions substidized with The Utils Classes */

    /** @return The next Course of the Menu */
    // TODO REMOVE THIS FUNCTIONS OR MAKE IT WITH OPTIONAL... right now this is often copared to be equal to null...
    public SharedCourse getStarterCourse() {
        return (hasStarter()) ? SharedMenuUtils.getStarterCourse(this): null;
    }

    /** @return true if the menu has entries */
    public boolean hasStarter() {
        return SharedMenuUtils.hasStarter(this);
    }

    // **************************************************
    // ADDING COURSES
    // **************************************************

    // public void addAVCourseAtIndex(SharedCourse avCourse, int courseIndex) {
    // GlobalAssert.that(0 <= courseIndex && courseIndex <= roboTaxiMenu.size());
    // roboTaxiMenu.add(courseIndex, avCourse);
    // }
    //
    // public void addAVCourseAsStarter(SharedCourse avCourse) {
    // roboTaxiMenu.add(0, avCourse);
    // }
    //
    // public void addAVCourseAsDessert(SharedCourse avCourse) {
    // roboTaxiMenu.add(roboTaxiMenu.size(), avCourse);
    // }

    // **************************************************
    // MOVING COURSES
    // **************************************************

    // public boolean moveAVCourseToPrev(SharedCourse sharedAVCourse) {
    // GlobalAssert.that(containsCourse(sharedAVCourse));
    // int i = getIndexOf(sharedAVCourse);
    // boolean swap = 0 < i && i < roboTaxiMenu.size();
    // if (swap)
    // Collections.swap(roboTaxiMenu, i, i - 1);
    // return swap;
    // }
    //
    // public boolean moveAVCourseToNext(SharedCourse sharedAVCourse) {
    // GlobalAssert.that(containsCourse(sharedAVCourse));
    // int i = getIndexOf(sharedAVCourse);
    // boolean swap = 0 <= i && i < roboTaxiMenu.size() - 1;
    // if (swap)
    // Collections.swap(roboTaxiMenu, i, i + 1);
    // return swap;
    // }
    //
    // /** Replaces the all the courses of this menu with the course order of the new
    // * menu. It is required that the new menu contains exactly the same courses as
    // * the old one.
    // *
    // * @param sharedAVMenu */
    // public void replaceWith(SharedMenu sharedAVMenu) {
    // GlobalAssert.that(containsSameCourses(sharedAVMenu));
    // clearWholeMenu();
    // GlobalAssert.that(roboTaxiMenu.isEmpty());
    // roboTaxiMenu.addAll(sharedAVMenu.getCourses());
    // }

    // **************************************************
    // REMOVING COURSES
    // **************************************************

    // // FIXME we have to rethink this. It is very dangerous to just let the people change the menu and remove courses.
    // // especially if there is the possibility to remove dropoff courses of onboard customers
    // public void removeStarterCourse() {
    // GlobalAssert.that(hasStarter());
    // removeAVCourse(0);
    // }
    //
    // public void removeAVCourse(int courseIndex) {
    // GlobalAssert.that(roboTaxiMenu.size() > courseIndex);
    // roboTaxiMenu.remove(courseIndex);
    // }
    //
    // public void removeAVCourse(SharedCourse sharedAVCourse) {
    // GlobalAssert.that(containsCourse(sharedAVCourse));
    // roboTaxiMenu.remove(sharedAVCourse);
    // }
    //
    // public void clearWholeMenu() {
    // roboTaxiMenu.clear();
    // }

    // **************************************************
    // GET COURSES
    // **************************************************

    // /** Gets the next course of the menu.
    // *
    // * @return */
    // public SharedCourse getStarterCourse() {
    // return roboTaxiMenu.isEmpty() ? null : roboTaxiMenu.get(0);
    // }

    // /** Gets the complete List of Courses in this Menu
    // *
    // * @return */
    // public List<SharedCourse> getCourses() {
    // return Collections.unmodifiableList(roboTaxiMenu);
    // // return roboTaxiMenu;
    // }
    //
    // /** Get the position of the course in the menu. 0 is the next course (called
    // * Starter). see {@link getStarterCourse}.
    // *
    // * @param course
    // * @return */
    // public int getIndexOf(SharedCourse course) {
    // return roboTaxiMenu.indexOf(course);
    // }
    //
    // /** Gets A deep Copy of this Menu
    // *
    // * @return */
    // public SharedMenu copy() {
    // return new SharedMenu(this);
    // }
    //
    // /** Gets the indices of the give SharedAVMealType.
    // *
    // * @param sharedRoboTaxiMealType
    // * @return */
    // public List<Integer> getPickupOrDropOffCoursesIndeces(SharedMealType sharedRoboTaxiMealType) {
    // List<Integer> indices = new ArrayList<>();
    // for (int i = 0; i < roboTaxiMenu.size(); i++) {
    // if (roboTaxiMenu.get(i).getMealType().equals(sharedRoboTaxiMealType)) {
    // indices.add(i);
    // }
    // }
    // return indices;
    // }
    //
    // public Set<String> getUniqueAVRequests() {
    // Set<String> ids = new HashSet<>();
    // roboTaxiMenu.stream().filter(sc -> !sc.getMealType().equals(SharedMealType.REDIRECT)).//
    // forEach(sc -> ids.add(sc.getRequestId().toString()));
    // return ids;
    // }
    //
    // public void printMenu() {
    // roboTaxiMenu.forEach(course -> System.out.println(course.getRequestId().toString() + ":\t" + course.getMealType().name()));
    // }

    // **************************************************
    // GET FUNCTIONS
    // **************************************************

    // public long getNumberPickups() {
    // return getNumberSharedMealType(SharedMealType.PICKUP);
    // }
    //
    // public long getNumberDropoffs() {
    // return getNumberSharedMealType(SharedMealType.DROPOFF);
    // }
    //
    // public long getNumberRedirections() {
    // return getNumberSharedMealType(SharedMealType.REDIRECT);
    // }
    //
    // private long getNumberSharedMealType(SharedMealType sharedMealType) {
    // return roboTaxiMenu.stream().filter(sc -> sc.getMealType().equals(sharedMealType)).count();
    // }
    //
    // public long getNumberCustomersOnBoard() {
    // return getNumberDropoffs() - getNumberPickups();
    // }
    //
    // public Set<String> getOnBoardRequestIds() {
    // Set<String> pickups = getIdsWithMealType(SharedMealType.PICKUP);
    // Set<String> dropoffs = getIdsWithMealType(SharedMealType.DROPOFF);
    // for (String avRequestIDpickup : pickups) {
    // boolean removeOk = dropoffs.remove(avRequestIDpickup);
    // GlobalAssert.that(removeOk);
    // }
    // GlobalAssert.that(getNumberCustomersOnBoard() == dropoffs.size());
    // return dropoffs;
    // }
    //
    // private Set<String> getIdsWithMealType(SharedMealType sharedMealType) {
    // return roboTaxiMenu.stream().filter(sc -> sc.getMealType().equals(sharedMealType)).map(sc -> sc.getRequestId()).collect(Collectors.toSet());
    // }

    // **************************************************
    // CHECK FUNCTIONS
    // **************************************************

    // /** @return true if the menu has entries */
    // public boolean hasStarter() {
    // return !roboTaxiMenu.isEmpty();
    // }

    // /** Checks if the given sharedAvCourse is contained in the menu
    // *
    // * @param sharedAVCourse
    // * @return */
    // public boolean containsCourse(SharedCourse sharedAVCourse) {
    // return roboTaxiMenu.contains(sharedAVCourse);
    // }
    //
    // /** @return false if any dropoff occurs after pickup in the menu */
    // public boolean checkNoPickupAfterDropoffOfSameRequest() {
    // for (SharedCourse course : roboTaxiMenu) {
    // if (course.getMealType().equals(SharedMealType.PICKUP)) {
    // int pickupIndex = roboTaxiMenu.indexOf(course);
    // SharedCourse dropoffCourse = getCorrespDropoff(course);
    // if (Objects.nonNull(dropoffCourse)) {
    // int dropofIndex = roboTaxiMenu.indexOf(dropoffCourse);
    // if (pickupIndex > dropofIndex) {
    // System.err.println("The SharedRoboTaxiMenu contains a pickup after its dropoff. Stopping Execution.");
    // return false;
    // }
    // }
    // }
    // }
    // return true;
    // }
    //
    // /** @param pickupCourse
    // * @return corresponding {@link SharedCourse} where dropoff takes place or
    // * null if not found */
    // public SharedCourse getCorrespDropoff(SharedCourse pickupCourse) {
    // GlobalAssert.that(pickupCourse.getMealType().equals(SharedMealType.PICKUP));
    // for (SharedCourse course : roboTaxiMenu) {
    // if (course.getRequestId().equals(pickupCourse.getRequestId())) {
    // if (course.getMealType().equals(SharedMealType.DROPOFF)) {
    // return course;
    // }
    // }
    // }
    // return null;
    // }
    //
    // /** Checks if the menu contains exactly the same courses as the inputed menu.
    // *
    // * @param sharedAVMenu
    // * @return true if the the two menus contain the same courses */
    // public boolean containsSameCourses(SharedMenu sharedAVMenu) {
    // return roboTaxiMenu.size() == sharedAVMenu.roboTaxiMenu.size() && //
    // sharedAVMenu.roboTaxiMenu.containsAll(roboTaxiMenu);
    // }
    //
    // public boolean checkAllCoursesAppearOnlyOnce() {
    // return new HashSet<>(roboTaxiMenu).size() == roboTaxiMenu.size();
    // }

    @Override
    public boolean equals(Object object) {
        if (object instanceof SharedMenu) {
            SharedMenu sharedAVMenu = (SharedMenu) object;
            boolean simpleCheck = roboTaxiMenu.equals(sharedAVMenu.getRoboTaxiMenu());
            List<SharedCourse> otherMenu = sharedAVMenu.roboTaxiMenu;
            // TODO LUXURY there is an easier way to check for equality
            if (otherMenu.size() == roboTaxiMenu.size()) {
                for (int i = 0; i < roboTaxiMenu.size(); i++)
                    if (!roboTaxiMenu.get(i).equals(sharedAVMenu.roboTaxiMenu.get(i))) {
                        GlobalAssert.that(!simpleCheck);
                        return false;
                    }
                GlobalAssert.that(simpleCheck);
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        // TODO SHARED not yet implemented
        throw new RuntimeException();
    }

}
