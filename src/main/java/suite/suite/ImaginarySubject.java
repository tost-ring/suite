package suite.suite;

import suite.suite.util.Glass;
import suite.suite.util.Browser;

import java.util.function.Supplier;

public class ImaginarySubject extends Subject {

    private Subject subject;
    private final Object frontier;

    ImaginarySubject(Subject subject, Object frontier) {
        this.subject = subject;
        this.frontier = frontier;
    }

    @Override
    public Subject at(Object element) {
        return new ImaginarySubject(this, element);
    }

    Subject burnAndJump() {
        subject = subject.materialize(frontier);
        return jump();
    }

    Subject jump() {
        return subject.sub(frontier);
    }

    @Override
    public Subject materialize(Object element) {
        return burnAndJump().materialize(element);
    }

    @Override
    public boolean real(Object element) {
        return jump().real(element);
    }

    @Override
    public Subject sub(Object element) {
        return jump().sub(element);
    }

    @Override
    public Subject sub() {
        return jump().sub();
    }

    @Override
    public Subject getFirst() {
        return jump().getFirst();
    }

    @Override
    public Subject getLast() {
        return jump().getLast();
    }

    @Override
    public Subject get(Object element) {
        return jump().get(element);
    }

    @Override
    public Object direct() {
        return jump().direct();
    }

    @Override
    public <B> B asExpected() {
        return jump().asExpected();
    }

    @Override
    public <B> B as(Class<B> requestedType) {
        return jump().as(requestedType);
    }

    @Override
    public <B> B as(Glass<? super B, B> requestedType) {
        return jump().as(requestedType);
    }

    @Override
    public <B> B as(Class<B> requestedType, B reserve) {
        return jump().as(requestedType, reserve);
    }

    @Override
    public <B> B as(Glass<? super B, B> requestedType, B reserve) {
        return jump().as(requestedType, reserve);
    }

    @Override
    public <B> B orGiven(B reserve) {
        return jump().orGiven(reserve);
    }

    @Override
    public <B> B orDo(Supplier<B> supplier) {
        return jump().orDo(supplier);
    }

    @Override
    public boolean is(Class<?> type) {
        return jump().is(type);
    }

    @Override
    public boolean present() {
        return jump().present();
    }

    @Override
    public boolean present(Object element) {
        return jump().present(element);
    }

    @Override
    public boolean absent() {
        return jump().absent();
    }

    @Override
    public boolean absent(Object element) {
        return jump().absent(element);
    }

    @Override
    public int size() {
        return jump().size();
    }

    @Override
    public Browser<Subject> iterator(boolean reverse) {
        return jump().iterator(reverse);
    }

    @Override
    public Subject set(Object element) {
        return burnAndJump().set(element);
    }

    @Override
    public Subject set(Object element, Subject $set) {
        return burnAndJump().set(element, $set);
    }

    @Override
    public Subject setBefore(Object sequent, Object element) {
        return burnAndJump().setBefore(sequent, element);
    }

    @Override
    public Subject setBefore(Object sequent, Object element, Subject $set) {
        return burnAndJump().setBefore(sequent, element, $set);
    }

    @Override
    public Subject unset() {
        return burnAndJump().unset();
    }

    @Override
    public Subject unset(Object element) {
        return burnAndJump().unset(element);
    }

    @Override
    public Subject separate() {
        return this;
    }

    @Override
    public Subject set() {
        return burnAndJump();
    }
}
