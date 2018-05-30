if (typeof kotlin === 'undefined') {
  throw new Error("Error loading module 'runtime-core-js'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'runtime-core-js'.");
}
this['runtime-core-js'] = function (_, Kotlin) {
  'use strict';
  var $$importsForInline$$ = _.$$importsForInline$$ || (_.$$importsForInline$$ = {});
  var throwCCE = Kotlin.throwCCE;
  var Unit = Kotlin.kotlin.Unit;
  var IllegalArgumentException = Kotlin.kotlin.IllegalArgumentException;
  var Iterable = Kotlin.kotlin.collections.Iterable;
  var Any = Object;
  var until = Kotlin.kotlin.ranges.until_dqglrj$;
  var CoroutineImpl = Kotlin.kotlin.coroutines.experimental.CoroutineImpl;
  var COROUTINE_SUSPENDED = Kotlin.kotlin.coroutines.experimental.intrinsics.COROUTINE_SUSPENDED;
  var buildSequence = Kotlin.kotlin.coroutines.experimental.buildSequence_of7nec$;
  var asIterable = Kotlin.kotlin.sequences.asIterable_veqyi0$;
  var Kind_CLASS = Kotlin.Kind.CLASS;
  var ensureNotNull = Kotlin.ensureNotNull;
  var equals = Kotlin.equals;
  var getCallableRef = Kotlin.getCallableRef;
  var IndexOutOfBoundsException = Kotlin.kotlin.IndexOutOfBoundsException;
  var get_lastIndex = Kotlin.kotlin.collections.get_lastIndex_55thoc$;
  var List = Kotlin.kotlin.collections.List;
  var hashCode = Kotlin.hashCode;
  var joinToString = Kotlin.kotlin.collections.joinToString_fmv235$;
  var NoSuchElementException = Kotlin.kotlin.NoSuchElementException;
  var ListIterator = Kotlin.kotlin.collections.ListIterator;
  var toString = Kotlin.toString;
  var ArrayList_init = Kotlin.kotlin.collections.ArrayList_init_ww73n8$;
  var IllegalStateException = Kotlin.kotlin.IllegalStateException;
  var emptySet = Kotlin.kotlin.collections.emptySet_287e2$;
  var Kind_OBJECT = Kotlin.Kind.OBJECT;
  var IntRange = Kotlin.kotlin.ranges.IntRange;
  var RuntimeException = Kotlin.kotlin.RuntimeException;
  var Kind_INTERFACE = Kotlin.Kind.INTERFACE;
  var HashSet_init = Kotlin.kotlin.collections.HashSet_init_287e2$;
  var flatten = Kotlin.kotlin.collections.flatten_u0ad8z$;
  var emptyList = Kotlin.kotlin.collections.emptyList_287e2$;
  var toList = Kotlin.kotlin.collections.toList_7wnvza$;
  var ArrayList_init_0 = Kotlin.kotlin.collections.ArrayList_init_mqih57$;
  var PropertyMetadata = Kotlin.PropertyMetadata;
  var Enum = Kotlin.kotlin.Enum;
  var lazy = Kotlin.kotlin.lazy_klfg04$;
  var throwISE = Kotlin.throwISE;
  var defineInlineFunction = Kotlin.defineInlineFunction;
  var wrapFunction = Kotlin.wrapFunction;
  var experimental = Kotlin.kotlin.coroutines.experimental;
  var Continuation = Kotlin.kotlin.coroutines.experimental.Continuation;
  var createCoroutine = Kotlin.kotlin.coroutines.experimental.createCoroutine_uao1qo$;
  var joinToString_0 = Kotlin.kotlin.collections.joinToString_cgipc5$;
  var CharRange = Kotlin.kotlin.ranges.CharRange;
  var Regex = Kotlin.kotlin.text.Regex_61zpoe$;
  var kotlin_js_internal_ShortCompanionObject = Kotlin.kotlin.js.internal.ShortCompanionObject;
  var toShort = Kotlin.toShort;
  var getPropertyCallableRef = Kotlin.getPropertyCallableRef;
  var toMutableSet = Kotlin.kotlin.collections.toMutableSet_7wnvza$;
  var plus = Kotlin.kotlin.collections.plus_mydzjv$;
  var get_lastIndex_0 = Kotlin.kotlin.collections.get_lastIndex_m7z4lg$;
  var contentDeepEquals = Kotlin.arrayDeepEquals;
  var toSet = Kotlin.kotlin.collections.toSet_7wnvza$;
  var toChar = Kotlin.toChar;
  var toBoxedChar = Kotlin.toBoxedChar;
  var replace = Kotlin.kotlin.text.replace_680rmw$;
  var toList_0 = Kotlin.kotlin.collections.toList_355ntz$;
  var unboxChar = Kotlin.unboxChar;
  var get_lastIndex_1 = Kotlin.kotlin.text.get_lastIndex_gw00vp$;
  var Iterator = Kotlin.kotlin.collections.Iterator;
  var setOf = Kotlin.kotlin.collections.setOf_mh5how$;
  var to = Kotlin.kotlin.to_ujzrz7$;
  RandomVariable.prototype = Object.create(Variable.prototype);
  RandomVariable.prototype.constructor = RandomVariable;
  BuiltinPredicate.prototype = Object.create(Predicate.prototype);
  BuiltinPredicate.prototype.constructor = BuiltinPredicate;
  EqualityLibrary$ObjectLiteral.prototype = Object.create(SimpleLibrary.prototype);
  EqualityLibrary$ObjectLiteral.prototype.constructor = EqualityLibrary$ObjectLiteral;
  NegationRule.prototype = Object.create(Rule.prototype);
  NegationRule.prototype.constructor = NegationRule;
  IdentityPredicate.prototype = Object.create(BuiltinPredicate.prototype);
  IdentityPredicate.prototype.constructor = IdentityPredicate;
  MathLibrary$ObjectLiteral.prototype = Object.create(SimpleLibrary.prototype);
  MathLibrary$ObjectLiteral.prototype.constructor = MathLibrary$ObjectLiteral;
  IsPredicate.prototype = Object.create(BuiltinPredicate.prototype);
  IsPredicate.prototype.constructor = IsPredicate;
  IsRule.prototype = Object.create(Rule.prototype);
  IsRule.prototype.constructor = IsRule;
  GreaterThanPredicate.prototype = Object.create(BuiltinPredicate.prototype);
  GreaterThanPredicate.prototype.constructor = GreaterThanPredicate;
  GreaterThanOrEqualPredicate.prototype = Object.create(BuiltinPredicate.prototype);
  GreaterThanOrEqualPredicate.prototype.constructor = GreaterThanOrEqualPredicate;
  LessThanPredicate.prototype = Object.create(BuiltinPredicate.prototype);
  LessThanPredicate.prototype.constructor = LessThanPredicate;
  LessThanOrEqualPredicate.prototype = Object.create(BuiltinPredicate.prototype);
  LessThanOrEqualPredicate.prototype.constructor = LessThanOrEqualPredicate;
  TypeSafetyLibrary$ObjectLiteral.prototype = Object.create(SimpleLibrary.prototype);
  TypeSafetyLibrary$ObjectLiteral.prototype.constructor = TypeSafetyLibrary$ObjectLiteral;
  IsAtomPredicate.prototype = Object.create(BuiltinPredicate.prototype);
  IsAtomPredicate.prototype.constructor = IsAtomPredicate;
  PrologException.prototype = Object.create(RuntimeException.prototype);
  PrologException.prototype.constructor = PrologException;
  PrologRuntimeException.prototype = Object.create(PrologException.prototype);
  PrologRuntimeException.prototype.constructor = PrologRuntimeException;
  IllegalDirectiveException.prototype = Object.create(PrologException.prototype);
  IllegalDirectiveException.prototype.constructor = IllegalDirectiveException;
  PredicatePrototype$asIdiomatic$ObjectLiteral.prototype = Object.create(Predicate.prototype);
  PredicatePrototype$asIdiomatic$ObjectLiteral.prototype.constructor = PredicatePrototype$asIdiomatic$ObjectLiteral;
  OperatorType.prototype = Object.create(Enum.prototype);
  OperatorType.prototype.constructor = OperatorType;
  LazySequenceBuilder$SequenceState.prototype = Object.create(Enum.prototype);
  LazySequenceBuilder$SequenceState.prototype.constructor = LazySequenceBuilder$SequenceState;
  AnonymousVariable.prototype = Object.create(Variable.prototype);
  AnonymousVariable.prototype.constructor = AnonymousVariable;
  PrologString.prototype = Object.create(List_0.prototype);
  PrologString.prototype.constructor = PrologString;
  UnificationException.prototype = Object.create(RuntimeException.prototype);
  UnificationException.prototype.constructor = UnificationException;
  NameError.prototype = Object.create(RuntimeException.prototype);
  NameError.prototype.constructor = NameError;
  VariableDiscrepancyException.prototype = Object.create(UnificationException.prototype);
  VariableDiscrepancyException.prototype.constructor = VariableDiscrepancyException;
  var Array_0 = Array;
  function ArityMap(items) {
    var tmp$;
    if (items === void 0) {
      var array = Array_0(6);
      var tmp$_0;
      tmp$_0 = array.length - 1 | 0;
      for (var i = 0; i <= tmp$_0; i++) {
        array[i] = null;
      }
      items = Kotlin.isArray(tmp$ = array) ? tmp$ : throwCCE();
    }
    this.items_hrqmjs$_0 = items;
    this.itemsResizeMutex_rz5x73$_0 = new Any();
    this.arities = asIterable(buildSequence(ArityMap$arities$lambda(this)));
  }
  Object.defineProperty(ArityMap.prototype, 'capacity', {
    get: function () {
      return this.items_hrqmjs$_0.length - 1 | 0;
    },
    set: function (value) {
      var tmp$;
      var array = Array_0(value + 1 | 0);
      var tmp$_0;
      tmp$_0 = array.length - 1 | 0;
      for (var i = 0; i <= tmp$_0; i++) {
        array[i] = i < this.items_hrqmjs$_0.length ? this.items_hrqmjs$_0[i] : null;
      }
      this.items_hrqmjs$_0 = Kotlin.isArray(tmp$ = array) ? tmp$ : throwCCE();
    }
  });
  ArityMap.prototype.get_za3lpa$ = function (arity) {
    if (arity < 0) {
      throw new IllegalArgumentException('The arity must positive or 0.');
    }
    if (arity >= this.items_hrqmjs$_0.length) {
      return null;
    }
    return this.items_hrqmjs$_0[arity];
  };
  ArityMap.prototype.set_wxm5ur$ = function (arity, item) {
    if (arity < 0) {
      throw new IllegalArgumentException('The arity must positive or 0.');
    }
    if (arity >= this.items_hrqmjs$_0.length) {
      this.capacity = arity;
    }
    this.items_hrqmjs$_0[arity] = item;
  };
  ArityMap.prototype.contains_za3lpa$ = function (arity) {
    if (arity < 0) {
      throw new IllegalArgumentException('The arity must positive or 0.');
    }
    if (arity >= this.items_hrqmjs$_0.length) {
      return false;
    }
    return this.items_hrqmjs$_0[arity] != null;
  };
  ArityMap.prototype.remove_za3lpa$ = function (arity) {
    if (arity < 0) {
      throw new IllegalArgumentException('The arity must be positive or 0');
    }
    if (arity < this.items_hrqmjs$_0.length) {
      this.items_hrqmjs$_0[arity] = null;
    }
  };
  ArityMap.prototype.values = function () {
    var tmp$;
    var $receiver = this.items_hrqmjs$_0;
    var destination = ArrayList_init();
    var tmp$_0;
    for (tmp$_0 = 0; tmp$_0 !== $receiver.length; ++tmp$_0) {
      var element = $receiver[tmp$_0];
      if (element != null)
        destination.add_11rb$(element);
    }
    return Kotlin.isType(tmp$ = destination, Iterable) ? tmp$ : throwCCE();
  };
  function ArityMap$arities$lambda(this$ArityMap_0) {
    return function ($receiver_0, continuation_0, suspended) {
      var instance = new Coroutine$ArityMap$arities$lambda(this$ArityMap_0, $receiver_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function Coroutine$ArityMap$arities$lambda(this$ArityMap_0, $receiver_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$this$ArityMap = this$ArityMap_0;
    this.local$tmp$ = void 0;
    this.local$$receiver = $receiver_0;
  }
  Coroutine$ArityMap$arities$lambda.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$ArityMap$arities$lambda.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$ArityMap$arities$lambda.prototype.constructor = Coroutine$ArityMap$arities$lambda;
  Coroutine$ArityMap$arities$lambda.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            var $receiver = until(0, this.local$this$ArityMap.items_hrqmjs$_0.length);
            var destination = ArrayList_init();
            var tmp$;
            tmp$ = $receiver.iterator();
            while (tmp$.hasNext()) {
              var element = tmp$.next();
              if (this.local$this$ArityMap.items_hrqmjs$_0[element] != null)
                destination.add_11rb$(element);
            }

            this.local$tmp$ = destination.iterator();
            this.state_0 = 2;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            if (!this.local$tmp$.hasNext()) {
              this.state_0 = 4;
              continue;
            }

            var element_0 = this.local$tmp$.next();
            this.state_0 = 3;
            this.result_0 = this.local$$receiver.yield_11rb$(element_0, this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            break;
          case 3:
            this.state_0 = 2;
            continue;
          case 4:
            return Unit;
        }
      }
       catch (e) {
        if (this.state_0 === 1)
          throw e;
        else {
          this.state_0 = this.exceptionState_0;
          this.exception_0 = e;
        }
      }
     while (true);
  };
  ArityMap.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'ArityMap',
    interfaces: []
  };
  function ImmutableSubList(source, startOffset, size) {
    this.source_0 = source;
    this.startOffset_0 = startOffset;
    this.size_o8kes8$_0 = size;
    if (this.startOffset_0 < 0)
      throw new IndexOutOfBoundsException('startOffset must be 0 or positive');
    if (this.size < 0)
      throw new IndexOutOfBoundsException('size must be 0 or positive');
    if ((this.startOffset_0 + this.size | 0) > this.source_0.size) {
      throw new IndexOutOfBoundsException((this.startOffset_0 + this.size | 0).toString());
    }
  }
  Object.defineProperty(ImmutableSubList.prototype, 'size', {
    get: function () {
      return this.size_o8kes8$_0;
    }
  });
  ImmutableSubList.prototype.contains_11rb$ = function (element) {
    var tmp$;
    ensureNotNull(element);
    tmp$ = this.size;
    for (var i = 0; i < tmp$; i++) {
      var el = this.source_0.get_za3lpa$(this.startOffset_0 + i | 0);
      if (el === element || equals(el, element))
        return true;
    }
    return false;
  };
  var Collection = Kotlin.kotlin.collections.Collection;
  ImmutableSubList.prototype.containsAll_brywnq$ = function (elements) {
    var predicate = getCallableRef('contains', function ($receiver, element) {
      return $receiver.contains_11rb$(element);
    }.bind(null, this));
    var all$result;
    all$break: do {
      var tmp$;
      if (Kotlin.isType(elements, Collection) && elements.isEmpty()) {
        all$result = true;
        break all$break;
      }
      tmp$ = elements.iterator();
      while (tmp$.hasNext()) {
        var element = tmp$.next();
        if (!predicate(element)) {
          all$result = false;
          break all$break;
        }
      }
      all$result = true;
    }
     while (false);
    return all$result;
  };
  ImmutableSubList.prototype.get_za3lpa$ = function (index) {
    if (index >= this.size)
      throw new IndexOutOfBoundsException(index.toString());
    return this.source_0.get_za3lpa$(this.startOffset_0 + index | 0);
  };
  ImmutableSubList.prototype.indexOf_11rb$ = function (element) {
    var tmp$;
    ensureNotNull(element);
    if (this.size === 1)
      return equals(this.source_0.get_za3lpa$(this.startOffset_0), element) ? 0 : -1;
    tmp$ = this.size;
    for (var i = 0; i < tmp$; i++) {
      var el = this.source_0.get_za3lpa$(this.startOffset_0 + i | 0);
      if (el === element || equals(el, element))
        return i;
    }
    return -1;
  };
  ImmutableSubList.prototype.isEmpty = function () {
    return this.size === 0;
  };
  ImmutableSubList.prototype.iterator = function () {
    return this.listIterator();
  };
  ImmutableSubList.prototype.lastIndexOf_11rb$ = function (element) {
    ensureNotNull(element);
    if (this.size === 1)
      return equals(this.source_0.get_za3lpa$(this.startOffset_0), element) ? 0 : -1;
    for (var i = get_lastIndex(this); i >= 0; i--) {
      var el = this.source_0.get_za3lpa$(this.startOffset_0 + i | 0);
      if (el === element || equals(el, element))
        return i;
    }
    return -1;
  };
  ImmutableSubList.prototype.listIterator = function () {
    return this.listIterator_za3lpa$(0);
  };
  ImmutableSubList.prototype.listIterator_za3lpa$ = function (index) {
    if (index < 0 || index >= this.size)
      throw new IndexOutOfBoundsException(index.toString());
    return new IndexBasedSubIteratorOverImmutableList(this.source_0, this.startOffset_0 + index | 0, this.size - index | 0);
  };
  ImmutableSubList.prototype.subList_vux9f0$ = function (fromIndex, toIndex) {
    if (fromIndex < 0 || fromIndex > this.size)
      throw new IndexOutOfBoundsException(fromIndex.toString());
    if (toIndex < 0 || toIndex > this.size)
      throw new IndexOutOfBoundsException(toIndex.toString());
    if (toIndex < fromIndex)
      throw new IllegalArgumentException();
    if (fromIndex === 0 && toIndex === get_lastIndex(this))
      return this;
    return new ImmutableSubList(this.source_0, this.startOffset_0 + fromIndex | 0, toIndex - fromIndex | 0);
  };
  ImmutableSubList.prototype.equals = function (other) {
    var tmp$;
    if (this === other)
      return true;
    if (!Kotlin.isType(other, List))
      return false;
    if (other.size !== this.size)
      return false;
    var selfIndex = 0;
    tmp$ = other.iterator();
    while (tmp$.hasNext()) {
      var otherEl = tmp$.next();
      var selfEl = this.source_0.get_za3lpa$(this.startOffset_0 + selfIndex | 0);
      if (!equals(selfEl, otherEl))
        return false;
      selfIndex = selfIndex + 1 | 0;
    }
    return true;
  };
  ImmutableSubList.prototype.hashCode = function () {
    var tmp$;
    var result = 0;
    tmp$ = this.iterator();
    while (tmp$.hasNext()) {
      var el = tmp$.next();
      result = (31 * result | 0) + hashCode(ensureNotNull(el)) | 0;
    }
    return result;
  };
  ImmutableSubList.prototype.toString = function () {
    return joinToString(this, ', ', '[', ']');
  };
  ImmutableSubList.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'ImmutableSubList',
    interfaces: [List]
  };
  function IndexBasedSubIteratorOverImmutableList(list, initialIndex, nElements) {
    if (initialIndex === void 0)
      initialIndex = 0;
    if (nElements === void 0)
      nElements = list.size;
    this.list_0 = list;
    this.initialIndex_0 = initialIndex;
    this.nElements_0 = nElements;
    if (this.initialIndex_0 < 0)
      throw new IndexOutOfBoundsException('initialIndex must be 0 or positive');
    if ((this.initialIndex_0 + this.nElements_0 | 0) > this.list_0.size)
      throw new IndexOutOfBoundsException();
    this.nextIndex_0 = this.initialIndex_0;
  }
  IndexBasedSubIteratorOverImmutableList.prototype.hasNext = function () {
    return (this.nextIndex_0 - this.initialIndex_0 | 0) < this.nElements_0;
  };
  IndexBasedSubIteratorOverImmutableList.prototype.next = function () {
    var tmp$;
    if (!this.hasNext())
      throw new NoSuchElementException();
    return this.list_0.get_za3lpa$((tmp$ = this.nextIndex_0, this.nextIndex_0 = tmp$ + 1 | 0, tmp$));
  };
  IndexBasedSubIteratorOverImmutableList.prototype.hasPrevious = function () {
    return this.nextIndex_0 > this.initialIndex_0;
  };
  IndexBasedSubIteratorOverImmutableList.prototype.nextIndex = function () {
    return this.hasNext() ? this.nextIndex_0 : this.nElements_0;
  };
  IndexBasedSubIteratorOverImmutableList.prototype.previous = function () {
    if (this.nextIndex_0 <= this.initialIndex_0)
      throw new NoSuchElementException();
    return this.list_0.get_za3lpa$((this.nextIndex_0 = this.nextIndex_0 - 1 | 0, this.nextIndex_0));
  };
  IndexBasedSubIteratorOverImmutableList.prototype.previousIndex = function () {
    return this.hasPrevious() ? this.nextIndex_0 - 1 | 0 : -1;
  };
  IndexBasedSubIteratorOverImmutableList.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'IndexBasedSubIteratorOverImmutableList',
    interfaces: [ListIterator]
  };
  function RandomVariable(counter) {
    Variable.call(this, '_G' + toString(counter));
    this.counter_0 = counter;
  }
  RandomVariable.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'RandomVariable',
    interfaces: [Variable]
  };
  function RandomVariableScope() {
    this.randomCounter_0 = Kotlin.Long.ZERO;
    this.variables_0 = ArrayList_init(30);
  }
  function RandomVariableScope$withRandomVariables$lambda(this$RandomVariableScope, closure$mapping) {
    return function (originalVariable) {
      if (originalVariable != null ? originalVariable.equals(Variable$Companion_getInstance().ANONYMOUS) : null) {
        return this$RandomVariableScope.createNewRandomVariable();
      }
       else {
        if (!closure$mapping.hasOriginal_cua0ab$(originalVariable)) {
          var randomVariable = this$RandomVariableScope.createNewRandomVariable();
          closure$mapping.storeSubstitution_9t9z2q$(originalVariable, randomVariable);
        }
        return ensureNotNull(closure$mapping.getSubstitution_cua0ab$(originalVariable));
      }
    };
  }
  RandomVariableScope.prototype.withRandomVariables_ggraum$ = function (term, mapping) {
    return term.substituteVariables_6ryr4$(RandomVariableScope$withRandomVariables$lambda(this, mapping));
  };
  RandomVariableScope.prototype.createNewRandomVariable = function () {
    var tmp$, tmp$_0;
    if (equals(this.randomCounter_0, new Kotlin.Long(-1, 2147483647))) {
      throw new PrologRuntimeException('Out of random variables');
    }
    if (Kotlin.Long.fromInt(this.variables_0.size).compareTo_11rb$(this.randomCounter_0) > 0) {
      return this.variables_0.get_za3lpa$((tmp$ = this.randomCounter_0, this.randomCounter_0 = tmp$.inc(), tmp$).toInt());
    }
     else {
      var rvar = new RandomVariable((tmp$_0 = this.randomCounter_0, this.randomCounter_0 = tmp$_0.inc(), tmp$_0));
      this.variables_0.add_11rb$(rvar);
      return rvar;
    }
  };
  RandomVariableScope.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'RandomVariableScope',
    interfaces: []
  };
  var LinkedHashMap_init = Kotlin.kotlin.collections.LinkedHashMap_init_q3lmfv$;
  function VariableMapping() {
    this.aToB_0 = LinkedHashMap_init();
    this.bToA_0 = LinkedHashMap_init();
  }
  VariableMapping.prototype.storeSubstitution_9t9z2q$ = function (original, substitution) {
    if (this.aToB_0.containsKey_11rb$(original)) {
      throw new IllegalStateException();
    }
    this.aToB_0.put_xwzc9p$(original, substitution);
    this.bToA_0.put_xwzc9p$(substitution, original);
  };
  var Map = Kotlin.kotlin.collections.Map;
  VariableMapping.prototype.hasOriginal_cua0ab$ = function (original) {
    var $receiver = this.aToB_0;
    var tmp$;
    return (Kotlin.isType(tmp$ = $receiver, Map) ? tmp$ : throwCCE()).containsKey_11rb$(original);
  };
  VariableMapping.prototype.hasSubstitution_cua0ab$ = function (substitution) {
    var $receiver = this.bToA_0;
    var tmp$;
    return (Kotlin.isType(tmp$ = $receiver, Map) ? tmp$ : throwCCE()).containsKey_11rb$(substitution);
  };
  VariableMapping.prototype.getSubstitution_cua0ab$ = function (original) {
    return this.aToB_0.get_11rb$(original);
  };
  VariableMapping.prototype.getOriginal_cua0ab$ = function (substitution) {
    return this.bToA_0.get_11rb$(substitution);
  };
  VariableMapping.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'VariableMapping',
    interfaces: []
  };
  var surrogateVarLHS;
  var surrogateVarRHS;
  var A;
  var B;
  var X;
  function BuiltinPredicate(name, arguments_0) {
    Predicate.call(this, name, arguments_0);
  }
  Object.defineProperty(BuiltinPredicate.prototype, 'variables', {
    get: function () {
      return emptySet();
    }
  });
  BuiltinPredicate.prototype.substituteVariables_6ryr4$ = function (mapper) {
    return this;
  };
  BuiltinPredicate.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'BuiltinPredicate',
    interfaces: [Predicate]
  };
  function EqualityLibrary$ObjectLiteral(entryStore, operatorRegistry) {
    SimpleLibrary.call(this, entryStore, operatorRegistry);
    this.add_jkxsdx$(new Predicate('=', [X, X]));
    this.add_jkxsdx$(NegationRule_getInstance());
    this.add_jkxsdx$(new Rule(new Predicate('\\=', [A, B]), new PredicateQuery(new Predicate('not', [new Predicate('=', [A, B])]))));
    this.add_jkxsdx$(IdentityPredicate_getInstance());
    this.add_jkxsdx$(new Rule(new Predicate('\\==', [A, B]), new PredicateQuery(new Predicate('not', [new Predicate('==', [A, B])]))));
    this.defineOperator_abg1pn$(new OperatorDefinition(700, OperatorType$XFX_getInstance(), '='));
    this.defineOperator_abg1pn$(new OperatorDefinition(700, OperatorType$XFX_getInstance(), '=='));
    this.defineOperator_abg1pn$(new OperatorDefinition(700, OperatorType$XFX_getInstance(), '\\='));
    this.defineOperator_abg1pn$(new OperatorDefinition(700, OperatorType$XFX_getInstance(), '\\=='));
  }
  EqualityLibrary$ObjectLiteral.$metadata$ = {
    kind: Kind_CLASS,
    interfaces: [SimpleLibrary]
  };
  var EqualityLibrary;
  function NegationRule() {
    NegationRule_instance = this;
    Rule.call(this, new Predicate('not', [X]), new PredicateQuery(new Predicate('not', [X])));
  }
  NegationRule.prototype.fulfill_okb83k$ = function (predicate, kb, randomVariableScope) {
    var tmp$, tmp$_0;
    if (!equals(predicate.name, 'not') || predicate.arguments.length !== 1)
      return Unification$Companion_getInstance().NONE;
    tmp$_0 = Kotlin.isType(tmp$ = predicate.arguments[0], Predicate) ? tmp$ : null;
    if (tmp$_0 == null) {
      return Unification$Companion_getInstance().NONE;
    }
    var arg0 = tmp$_0;
    var proof = kb.fulfill_idmyxu$(arg0, randomVariableScope);
    if (proof.tryAdvance() != null) {
      return Unification$Companion_getInstance().NONE;
    }
     else {
      return Unification$Companion_getInstance().SINGLETON;
    }
  };
  NegationRule.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'NegationRule',
    interfaces: [Rule]
  };
  var NegationRule_instance = null;
  function NegationRule_getInstance() {
    if (NegationRule_instance === null) {
      new NegationRule();
    }
    return NegationRule_instance;
  }
  function IdentityPredicate() {
    IdentityPredicate_instance = this;
    BuiltinPredicate.call(this, '==', [surrogateVarLHS, surrogateVarRHS]);
  }
  IdentityPredicate.prototype.unify_dtn93p$$default = function (rhs, randomVarsScope) {
    var tmp$, tmp$_0;
    tmp$ = this.unify_dtn93p$(rhs, randomVarsScope, BuiltinPredicate.prototype.unify_dtn93p$$default.bind(this));
    if (tmp$ == null) {
      return null;
    }
    var surrogateUnification = tmp$;
    if ((tmp$_0 = surrogateUnification.variableValues.get_cua0ab$(surrogateVarLHS)) != null ? tmp$_0.equals(surrogateUnification.variableValues.get_cua0ab$(surrogateVarRHS)) : null) {
      return Unification$Companion_getInstance().TRUE;
    }
     else {
      return Unification$Companion_getInstance().FALSE;
    }
  };
  IdentityPredicate.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'IdentityPredicate',
    interfaces: [BuiltinPredicate]
  };
  var IdentityPredicate_instance = null;
  function IdentityPredicate_getInstance() {
    if (IdentityPredicate_instance === null) {
      new IdentityPredicate();
    }
    return IdentityPredicate_instance;
  }
  function MathLibrary$ObjectLiteral(entryStore, operatorRegistry) {
    SimpleLibrary.call(this, entryStore, operatorRegistry);
    this.add_jkxsdx$(IsRule_getInstance());
    this.add_jkxsdx$(LessThanPredicate_getInstance());
    this.add_jkxsdx$(LessThanOrEqualPredicate_getInstance());
    this.add_jkxsdx$(GreaterThanPredicate_getInstance());
    this.add_jkxsdx$(GreaterThanOrEqualPredicate_getInstance());
    this.defineOperator_abg1pn$(new OperatorDefinition(700, OperatorType$XFX_getInstance(), '<'));
    this.defineOperator_abg1pn$(new OperatorDefinition(700, OperatorType$XFX_getInstance(), '=<'));
    this.defineOperator_abg1pn$(new OperatorDefinition(700, OperatorType$XFX_getInstance(), '=\\='));
    this.defineOperator_abg1pn$(new OperatorDefinition(700, OperatorType$XFX_getInstance(), '>'));
    this.defineOperator_abg1pn$(new OperatorDefinition(700, OperatorType$XFX_getInstance(), '>='));
    this.defineOperator_abg1pn$(new OperatorDefinition(700, OperatorType$XFX_getInstance(), 'is'));
    this.defineOperator_abg1pn$(new OperatorDefinition(500, OperatorType$YFX_getInstance(), '+'));
    this.defineOperator_abg1pn$(new OperatorDefinition(500, OperatorType$YFX_getInstance(), '-'));
    this.defineOperator_abg1pn$(new OperatorDefinition(500, OperatorType$YFX_getInstance(), 'xor'));
    this.defineOperator_abg1pn$(new OperatorDefinition(400, OperatorType$YFX_getInstance(), '*'));
    this.defineOperator_abg1pn$(new OperatorDefinition(400, OperatorType$YFX_getInstance(), 'mod'));
    this.defineOperator_abg1pn$(new OperatorDefinition(200, OperatorType$XFX_getInstance(), '**'));
    this.defineOperator_abg1pn$(new OperatorDefinition(200, OperatorType$XFY_getInstance(), '^'));
    this.defineOperator_abg1pn$(new OperatorDefinition(200, OperatorType$FY_getInstance(), '+'));
    this.defineOperator_abg1pn$(new OperatorDefinition(200, OperatorType$FY_getInstance(), '-'));
  }
  MathLibrary$ObjectLiteral.$metadata$ = {
    kind: Kind_CLASS,
    interfaces: [SimpleLibrary]
  };
  var MathLibrary;
  function MathOperatorRegistry() {
    MathOperatorRegistry_instance = this;
    this.calculators_0 = LinkedHashMap_init();
    this.registerOperator_njq2pa$('+', getCallableRef('plus', function ($receiver, other) {
      return $receiver.plus_icrx7q$(other);
    }));
    this.registerOperator_njq2pa$('-', getCallableRef('minus', function ($receiver, other) {
      return $receiver.minus_icrx7q$(other);
    }));
    this.registerOperator_njq2pa$('*', getCallableRef('times', function ($receiver, other) {
      return $receiver.times_icrx7q$(other);
    }));
    this.registerOperator_njq2pa$('/', getCallableRef('div', function ($receiver, other) {
      return $receiver.div_icrx7q$(other);
    }));
    this.registerOperator_njq2pa$('mod', getCallableRef('rem', function ($receiver, other) {
      return $receiver.rem_icrx7q$(other);
    }));
    this.registerOperator_njq2pa$('^', getCallableRef('toThe', function ($receiver, other) {
      return $receiver.toThe_icrx7q$(other);
    }));
    this.registerOperator_g93aya$('+', getCallableRef('unaryPlus', function ($receiver) {
      return $receiver.unaryPlus();
    }));
    this.registerOperator_g93aya$('-', getCallableRef('unaryMinus', function ($receiver) {
      return $receiver.unaryMinus();
    }));
  }
  MathOperatorRegistry.prototype.registerOperator_uio9hx$ = function (operatorName, arities, calculator) {
    var tmp$, tmp$_0, tmp$_1;
    if (arities.first <= 0) {
      throw new IllegalArgumentException('Cannot register an arithmetic operator with arity less than 1');
    }
    var arityMap;
    var $receiver = this.calculators_0;
    var tmp$_2;
    if ((Kotlin.isType(tmp$_2 = $receiver, Map) ? tmp$_2 : throwCCE()).containsKey_11rb$(operatorName)) {
      arityMap = ensureNotNull(this.calculators_0.get_11rb$(operatorName));
    }
     else {
      arityMap = new ArityMap();
      var $receiver_0 = this.calculators_0;
      var value = arityMap;
      $receiver_0.put_xwzc9p$(operatorName, value);
    }
    tmp$ = arities.first;
    tmp$_0 = arities.last;
    tmp$_1 = arities.step;
    for (var arity = tmp$; arity <= tmp$_0; arity += tmp$_1) {
      arityMap.set_wxm5ur$(arity, calculator);
    }
  };
  MathOperatorRegistry.prototype.getCalculator_bm4lxs$ = function (operatorName, arity) {
    var tmp$;
    return (tmp$ = this.calculators_0.get_11rb$(operatorName)) != null ? tmp$.get_za3lpa$(arity) : null;
  };
  MathOperatorRegistry.prototype.evaluate_76kv2e$ = function (predicate) {
    var tmp$;
    tmp$ = this.getCalculator_bm4lxs$(predicate.name, predicate.arity);
    if (tmp$ == null) {
      throw new PrologRuntimeException('Arithmetic operator ' + predicate.name + '/' + predicate.arity + ' is not defined');
    }
    var calculator = tmp$;
    return calculator(predicate);
  };
  function MathOperatorRegistry$registerOperator$lambda(closure$operatorName, closure$calculator) {
    return function (predicate) {
      if (predicate.arity !== 1 || !equals(predicate.name, closure$operatorName))
        throw new PrologRuntimeException('Calculator for ' + closure$operatorName + '/1 cannot be invoked with an instance of ' + predicate.name + '/' + predicate.arity);
      return closure$calculator(get_asNumber(predicate.arguments[0]));
    };
  }
  MathOperatorRegistry.prototype.registerOperator_g93aya$ = function (operatorName, calculator) {
    this.registerOperator_uio9hx$(operatorName, new IntRange(1, 1), MathOperatorRegistry$registerOperator$lambda(operatorName, calculator));
  };
  function MathOperatorRegistry$registerOperator$lambda_0(closure$operatorName, closure$calculator) {
    return function (predicate) {
      if (predicate.arity !== 2 || !equals(predicate.name, closure$operatorName))
        throw new PrologRuntimeException('Calculator for ' + closure$operatorName + '/2 cannot be invoked with an instance of ' + predicate.name + '/' + predicate.arity);
      return closure$calculator(get_asNumber(predicate.arguments[0]), get_asNumber(predicate.arguments[1]));
    };
  }
  MathOperatorRegistry.prototype.registerOperator_njq2pa$ = function (operatorName, calculator) {
    this.registerOperator_uio9hx$(operatorName, new IntRange(2, 2), MathOperatorRegistry$registerOperator$lambda_0(operatorName, calculator));
  };
  MathOperatorRegistry.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'MathOperatorRegistry',
    interfaces: []
  };
  var MathOperatorRegistry_instance = null;
  function MathOperatorRegistry_getInstance() {
    if (MathOperatorRegistry_instance === null) {
      new MathOperatorRegistry();
    }
    return MathOperatorRegistry_instance;
  }
  function IsPredicate() {
    IsPredicate_instance = this;
    BuiltinPredicate.call(this, 'is', [A, B]);
  }
  IsPredicate.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'IsPredicate',
    interfaces: [BuiltinPredicate]
  };
  var IsPredicate_instance = null;
  function IsPredicate_getInstance() {
    if (IsPredicate_instance === null) {
      new IsPredicate();
    }
    return IsPredicate_instance;
  }
  function IsRule() {
    IsRule_instance = this;
    Rule.call(this, IsPredicate_getInstance(), new PredicateQuery(IsPredicate_getInstance()));
  }
  IsRule.prototype.fulfill_okb83k$ = function (predicate, kb, randomVariableScope) {
    var tmp$, tmp$_0, tmp$_1;
    var randomMapping = new VariableMapping();
    var randomPredicate = randomVariableScope.withRandomVariables_ggraum$(predicate, randomMapping);
    tmp$ = this.head.unify_dtn93p$(randomPredicate);
    if (tmp$ == null) {
      return Unification$Companion_getInstance().NONE;
    }
    var predicateAndHeadUnification = tmp$;
    var valForA = predicateAndHeadUnification.variableValues.get_cua0ab$(A);
    var valForB = predicateAndHeadUnification.variableValues.get_cua0ab$(B);
    var bucket = VariableBucket_init();
    if (Kotlin.isType(valForA, Variable)) {
      bucket.instantiate_hg6dwi$(valForA, get_asNumber(valForB));
      return LazySequence$Companion_getInstance().of_i5x0yv$([new Unification(bucket.withVariablesResolvedFrom_ydv0fz$(randomMapping))]);
    }
     else if (Kotlin.isType(valForB, Variable)) {
      bucket.instantiate_hg6dwi$(valForB, get_asNumber(valForA));
      return LazySequence$Companion_getInstance().of_i5x0yv$([new Unification(bucket.withVariablesResolvedFrom_ydv0fz$(randomMapping))]);
    }
     else if (Kotlin.isType(valForA, Number_0)) {
      if ((tmp$_0 = get_asNumber(valForB)) != null ? tmp$_0.equals(valForA) : null) {
        return Unification$Companion_getInstance().SINGLETON;
      }
       else {
        return Unification$Companion_getInstance().NONE;
      }
    }
     else if (Kotlin.isType(valForB, Number_0)) {
      if ((tmp$_1 = get_asNumber(valForA)) != null ? tmp$_1.equals(valForB) : null) {
        return Unification$Companion_getInstance().SINGLETON;
      }
       else {
        return Unification$Companion_getInstance().NONE;
      }
    }
     else {
      return Unification$Companion_getInstance().NONE;
    }
  };
  IsRule.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'IsRule',
    interfaces: [Rule]
  };
  var IsRule_instance = null;
  function IsRule_getInstance() {
    if (IsRule_instance === null) {
      new IsRule();
    }
    return IsRule_instance;
  }
  function get_asNumber($receiver) {
    if (Kotlin.isType($receiver, Atom))
      throw new PrologRuntimeException('is/2: ' + $receiver + ' is not a number');
    else if (Kotlin.isType($receiver, Number_0))
      return $receiver;
    else if (Kotlin.isType($receiver, List_0))
      throw new PrologRuntimeException('is/2: ' + $receiver + ' is not a number');
    else if (Kotlin.isType($receiver, Variable))
      throw new PrologRuntimeException('is/2: Arguments not sufficiently instantiated: ' + $receiver);
    else if (Kotlin.isType($receiver, Predicate))
      return MathOperatorRegistry_getInstance().evaluate_76kv2e$($receiver);
    else
      throw new PrologRuntimeException('is/2: cannot evaluate term ' + $receiver);
  }
  function GreaterThanPredicate() {
    GreaterThanPredicate_instance = this;
    BuiltinPredicate.call(this, '>', [A, B]);
  }
  GreaterThanPredicate.prototype.unify_dtn93p$$default = function (rhs, randomVarsScope) {
    var tmp$;
    tmp$ = this.unify_dtn93p$(rhs, randomVarsScope, BuiltinPredicate.prototype.unify_dtn93p$$default.bind(this));
    if (tmp$ == null) {
      return Unification$Companion_getInstance().FALSE;
    }
    var unification = tmp$;
    var valForA = unification.variableValues.get_cua0ab$(A);
    var valForB = unification.variableValues.get_cua0ab$(B);
    if (get_asNumber(valForA).compareTo_icrx7q$(get_asNumber(valForB)) > 0) {
      return Unification$Companion_getInstance().TRUE;
    }
     else {
      return Unification$Companion_getInstance().FALSE;
    }
  };
  GreaterThanPredicate.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'GreaterThanPredicate',
    interfaces: [BuiltinPredicate]
  };
  var GreaterThanPredicate_instance = null;
  function GreaterThanPredicate_getInstance() {
    if (GreaterThanPredicate_instance === null) {
      new GreaterThanPredicate();
    }
    return GreaterThanPredicate_instance;
  }
  function GreaterThanOrEqualPredicate() {
    GreaterThanOrEqualPredicate_instance = this;
    BuiltinPredicate.call(this, '>=', [A, B]);
  }
  GreaterThanOrEqualPredicate.prototype.unify_dtn93p$$default = function (rhs, randomVarsScope) {
    var tmp$;
    tmp$ = this.unify_dtn93p$(rhs, randomVarsScope, BuiltinPredicate.prototype.unify_dtn93p$$default.bind(this));
    if (tmp$ == null) {
      return Unification$Companion_getInstance().FALSE;
    }
    var unification = tmp$;
    var valForA = unification.variableValues.get_cua0ab$(A);
    var valForB = unification.variableValues.get_cua0ab$(B);
    if (get_asNumber(valForA).compareTo_icrx7q$(get_asNumber(valForB)) > 0) {
      return Unification$Companion_getInstance().TRUE;
    }
     else {
      return Unification$Companion_getInstance().FALSE;
    }
  };
  GreaterThanOrEqualPredicate.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'GreaterThanOrEqualPredicate',
    interfaces: [BuiltinPredicate]
  };
  var GreaterThanOrEqualPredicate_instance = null;
  function GreaterThanOrEqualPredicate_getInstance() {
    if (GreaterThanOrEqualPredicate_instance === null) {
      new GreaterThanOrEqualPredicate();
    }
    return GreaterThanOrEqualPredicate_instance;
  }
  function LessThanPredicate() {
    LessThanPredicate_instance = this;
    BuiltinPredicate.call(this, '<', [A, B]);
  }
  LessThanPredicate.prototype.unify_dtn93p$$default = function (rhs, randomVarsScope) {
    var tmp$;
    tmp$ = this.unify_dtn93p$(rhs, randomVarsScope, BuiltinPredicate.prototype.unify_dtn93p$$default.bind(this));
    if (tmp$ == null) {
      return Unification$Companion_getInstance().FALSE;
    }
    var unification = tmp$;
    var valForA = unification.variableValues.get_cua0ab$(A);
    var valForB = unification.variableValues.get_cua0ab$(B);
    if (get_asNumber(valForA).compareTo_icrx7q$(get_asNumber(valForB)) > 0) {
      return Unification$Companion_getInstance().TRUE;
    }
     else {
      return Unification$Companion_getInstance().FALSE;
    }
  };
  LessThanPredicate.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'LessThanPredicate',
    interfaces: [BuiltinPredicate]
  };
  var LessThanPredicate_instance = null;
  function LessThanPredicate_getInstance() {
    if (LessThanPredicate_instance === null) {
      new LessThanPredicate();
    }
    return LessThanPredicate_instance;
  }
  function LessThanOrEqualPredicate() {
    LessThanOrEqualPredicate_instance = this;
    BuiltinPredicate.call(this, '=<', [A, B]);
  }
  LessThanOrEqualPredicate.prototype.unify_dtn93p$$default = function (rhs, randomVarsScope) {
    var tmp$;
    tmp$ = this.unify_dtn93p$(rhs, randomVarsScope, BuiltinPredicate.prototype.unify_dtn93p$$default.bind(this));
    if (tmp$ == null) {
      return Unification$Companion_getInstance().FALSE;
    }
    var unification = tmp$;
    var valForA = unification.variableValues.get_cua0ab$(A);
    var valForB = unification.variableValues.get_cua0ab$(B);
    if (get_asNumber(valForA).compareTo_icrx7q$(get_asNumber(valForB)) > 0) {
      return Unification$Companion_getInstance().TRUE;
    }
     else {
      return Unification$Companion_getInstance().FALSE;
    }
  };
  LessThanOrEqualPredicate.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'LessThanOrEqualPredicate',
    interfaces: [BuiltinPredicate]
  };
  var LessThanOrEqualPredicate_instance = null;
  function LessThanOrEqualPredicate_getInstance() {
    if (LessThanOrEqualPredicate_instance === null) {
      new LessThanOrEqualPredicate();
    }
    return LessThanOrEqualPredicate_instance;
  }
  function TypeSafetyLibrary$ObjectLiteral(entryStore, operatorRegistry) {
    SimpleLibrary.call(this, entryStore, operatorRegistry);
    this.add_jkxsdx$(IsAtomPredicate_getInstance());
  }
  TypeSafetyLibrary$ObjectLiteral.$metadata$ = {
    kind: Kind_CLASS,
    interfaces: [SimpleLibrary]
  };
  var TypeSafetyLibrary;
  function IsAtomPredicate() {
    IsAtomPredicate_instance = this;
    BuiltinPredicate.call(this, 'atom', [X]);
  }
  IsAtomPredicate.prototype.unify_dtn93p$$default = function (rhs, randomVarsScope) {
    var tmp$;
    tmp$ = this.unify_dtn93p$(rhs, randomVarsScope, BuiltinPredicate.prototype.unify_dtn93p$$default.bind(this));
    if (tmp$ == null) {
      return null;
    }
    var surrogateUnification = tmp$;
    if (Kotlin.isType(surrogateUnification.variableValues.get_cua0ab$(X), Atom)) {
      return Unification$Companion_getInstance().TRUE;
    }
     else {
      return Unification$Companion_getInstance().FALSE;
    }
  };
  IsAtomPredicate.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'IsAtomPredicate',
    interfaces: [BuiltinPredicate]
  };
  var IsAtomPredicate_instance = null;
  function IsAtomPredicate_getInstance() {
    if (IsAtomPredicate_instance === null) {
      new IsAtomPredicate();
    }
    return IsAtomPredicate_instance;
  }
  function PrologException(message, cause) {
    if (cause === void 0)
      cause = null;
    RuntimeException.call(this, message);
    this.cause_88nx9k$_0 = cause;
    this.name = 'PrologException';
  }
  Object.defineProperty(PrologException.prototype, 'cause', {
    get: function () {
      return this.cause_88nx9k$_0;
    }
  });
  PrologException.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'PrologException',
    interfaces: [RuntimeException]
  };
  function PrologRuntimeException(message, cause) {
    if (cause === void 0)
      cause = null;
    PrologException.call(this, message, cause);
    this.name = 'PrologRuntimeException';
  }
  PrologRuntimeException.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'PrologRuntimeException',
    interfaces: [PrologException]
  };
  function IllegalDirectiveException(message, cause) {
    if (cause === void 0)
      cause = null;
    PrologException.call(this, message, cause);
    this.name = 'IllegalDirectiveException';
  }
  IllegalDirectiveException.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'IllegalDirectiveException',
    interfaces: [PrologException]
  };
  function IllegalDirectiveException_init(rejectedDirective, $this) {
    $this = $this || Object.create(IllegalDirectiveException.prototype);
    var tmp$;
    if (!equals(rejectedDirective.name, ':-') || rejectedDirective.arity !== 1) {
      tmp$ = 'Directives must be instances of :-/1';
    }
     else {
      tmp$ = 'Unsupported or illegal directive: ' + rejectedDirective;
    }
    IllegalDirectiveException.call($this, tmp$);
    return $this;
  }
  function DefaultKnowledgeBase() {
    this.library = new SimpleLibrary(new DoublyIndexedLibraryEntryStore(), new DefaultOperatorRegistry(true));
    this.operatorRegistry_xpfnja$_0 = this.library;
    this.load_5bfbyx$(EqualityLibrary);
    this.load_5bfbyx$(TypeSafetyLibrary);
    this.load_5bfbyx$(MathLibrary);
  }
  Object.defineProperty(DefaultKnowledgeBase.prototype, 'operatorRegistry', {
    get: function () {
      return this.operatorRegistry_xpfnja$_0;
    }
  });
  function DefaultKnowledgeBase$fulfill$lambda(this$DefaultKnowledgeBase_0, closure$predicate_0, closure$randomVarsScope_0, closure$replaced_0, closure$termMappings_0) {
    return function ($receiver_0, continuation_0, suspended) {
      var instance = new Coroutine$DefaultKnowledgeBase$fulfill$lambda(this$DefaultKnowledgeBase_0, closure$predicate_0, closure$randomVarsScope_0, closure$replaced_0, closure$termMappings_0, $receiver_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function Coroutine$DefaultKnowledgeBase$fulfill$lambda(this$DefaultKnowledgeBase_0, closure$predicate_0, closure$randomVarsScope_0, closure$replaced_0, closure$termMappings_0, $receiver_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$this$DefaultKnowledgeBase = this$DefaultKnowledgeBase_0;
    this.local$closure$predicate = closure$predicate_0;
    this.local$closure$randomVarsScope = closure$randomVarsScope_0;
    this.local$closure$replaced = closure$replaced_0;
    this.local$closure$termMappings = closure$termMappings_0;
    this.local$tmp$ = void 0;
    this.local$$receiver = $receiver_0;
  }
  Coroutine$DefaultKnowledgeBase$fulfill$lambda.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$DefaultKnowledgeBase$fulfill$lambda.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$DefaultKnowledgeBase$fulfill$lambda.prototype.constructor = Coroutine$DefaultKnowledgeBase$fulfill$lambda;
  Coroutine$DefaultKnowledgeBase$fulfill$lambda.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.local$tmp$ = this.local$this$DefaultKnowledgeBase.library.findFor_76kv2e$(this.local$closure$predicate).iterator();
            this.state_0 = 2;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            if (!this.local$tmp$.hasNext()) {
              this.state_0 = 7;
              continue;
            }

            var libEntry = this.local$tmp$.next();
            if (Kotlin.isType(libEntry, Predicate)) {
              var knownPredicateReplaced = this.local$closure$randomVarsScope.withRandomVariables_ggraum$(libEntry, new VariableMapping());
              var unification = knownPredicateReplaced.unify_dtn93p$(this.local$closure$replaced);
              if (unification != null) {
                var resolvedBucket = unification.variableValues.withVariablesResolvedFrom_ydv0fz$(this.local$closure$termMappings);
                resolvedBucket.retainAll_uifa2s$(this.local$closure$predicate.variables);
                this.state_0 = 4;
                this.result_0 = this.local$$receiver.yield_11rb$(new Unification(resolvedBucket), this);
                if (this.result_0 === COROUTINE_SUSPENDED)
                  return COROUTINE_SUSPENDED;
                break;
              }
               else {
                this.state_0 = 5;
                continue;
              }
            }
             else {
              this.state_0 = 3;
              this.result_0 = this.local$$receiver.yieldAll_481s4d$(libEntry.unifyWithKnowledge_okb83k$(this.local$closure$predicate, this.local$this$DefaultKnowledgeBase, this.local$closure$randomVarsScope), this);
              if (this.result_0 === COROUTINE_SUSPENDED)
                return COROUTINE_SUSPENDED;
              break;
            }

          case 3:
            this.state_0 = 6;
            continue;
          case 4:
            this.state_0 = 5;
            continue;
          case 5:
            this.state_0 = 6;
            continue;
          case 6:
            this.state_0 = 2;
            continue;
          case 7:
            return Unit;
        }
      }
       catch (e) {
        if (this.state_0 === 1)
          throw e;
        else {
          this.state_0 = this.exceptionState_0;
          this.exception_0 = e;
        }
      }
     while (true);
  };
  DefaultKnowledgeBase.prototype.fulfill_idmyxu$$default = function (predicate, randomVarsScope) {
    var termMappings = new VariableMapping();
    var replaced = randomVarsScope.withRandomVariables_ggraum$(predicate, termMappings);
    return buildLazySequence(DefaultKnowledgeBase$fulfill$lambda(this, predicate, randomVarsScope, replaced, termMappings));
  };
  DefaultKnowledgeBase.prototype.assert_76kv2e$ = function (predicate) {
    this.library.add_jkxsdx$(predicate);
  };
  DefaultKnowledgeBase.prototype.defineRule_mzounx$ = function (rule) {
    this.library.add_jkxsdx$(rule);
  };
  DefaultKnowledgeBase.prototype.load_5bfbyx$ = function (library) {
    this.library.include_5bfbyx$(library);
  };
  DefaultKnowledgeBase.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'DefaultKnowledgeBase',
    interfaces: [MutableKnowledgeBase]
  };
  function Rule(head, query) {
    this.head = head;
    this.query_wzeslf$_0 = query;
    this.name_a694pq$_0 = this.head.name;
    this.arity_pd41xq$_0 = this.head.arity;
  }
  Object.defineProperty(Rule.prototype, 'name', {
    get: function () {
      return this.name_a694pq$_0;
    }
  });
  Object.defineProperty(Rule.prototype, 'arity', {
    get: function () {
      return this.arity_pd41xq$_0;
    }
  });
  function Rule$fulfill$lambda(closure$randomPredicate, closure$predicateAndHeadUnification, closure$predicateRandomVarsMapping) {
    return function (unification) {
      var tmp$;
      var solutionVars = VariableBucket_init();
      tmp$ = closure$randomPredicate.variables.iterator();
      while (tmp$.hasNext()) {
        var randomPredicateVariable = tmp$.next();
        if (closure$predicateAndHeadUnification.variableValues.isInstantiated_cua0ab$(randomPredicateVariable)) {
          var value = closure$predicateAndHeadUnification.variableValues.get_cua0ab$(randomPredicateVariable).substituteVariables_6ryr4$(unification.variableValues.asSubstitutionMapper());
          solutionVars.instantiate_hg6dwi$(randomPredicateVariable, value);
        }
         else if (unification.variableValues.isInstantiated_cua0ab$(randomPredicateVariable)) {
          var originalVar = ensureNotNull(closure$predicateRandomVarsMapping.getOriginal_cua0ab$(randomPredicateVariable));
          solutionVars.instantiate_hg6dwi$(originalVar, unification.variableValues.get_cua0ab$(randomPredicateVariable));
        }
      }
      return new Unification(solutionVars.withVariablesResolvedFrom_ydv0fz$(closure$predicateRandomVarsMapping));
    };
  }
  Rule.prototype.fulfill_okb83k$ = function (predicate, kb, randomVariableScope) {
    var predicateRandomVarsMapping = new VariableMapping();
    var randomPredicate = randomVariableScope.withRandomVariables_ggraum$(predicate, predicateRandomVarsMapping);
    var ruleRandomVarsMapping = new VariableMapping();
    var randomHead = randomVariableScope.withRandomVariables_ggraum$(this.head, ruleRandomVarsMapping);
    var predicateAndHeadUnification = randomHead.unify_dtn93p$(randomPredicate);
    if (predicateAndHeadUnification == null) {
      return Unification$Companion_getInstance().NONE;
    }
    var randomQuery = this.query_wzeslf$_0.withRandomVariables_fixsiv$(randomVariableScope, ruleRandomVarsMapping).substituteVariables_t6ifwg$(predicateAndHeadUnification.variableValues);
    return mapRemaining(randomQuery.findProofWithin_5dl3t6$(kb, VariableBucket_init(), randomVariableScope), Rule$fulfill$lambda(randomPredicate, predicateAndHeadUnification, predicateRandomVarsMapping));
  };
  Rule.prototype.unifyWithKnowledge_okb83k$ = function (other, kb, randomVariableScope) {
    return this.fulfill_okb83k$(other, kb, randomVariableScope);
  };
  Rule.prototype.toString = function () {
    return this.head.toString() + ' :- ' + this.query_wzeslf$_0;
  };
  Rule.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Rule',
    interfaces: [LibraryEntry]
  };
  function KnowledgeBase() {
    KnowledgeBase$Companion_getInstance();
  }
  KnowledgeBase.prototype.fulfill_idmyxu$ = function (predicate, randomVarsScope, callback$default) {
    if (randomVarsScope === void 0)
      randomVarsScope = new RandomVariableScope();
    return callback$default ? callback$default(predicate, randomVarsScope) : this.fulfill_idmyxu$$default(predicate, randomVarsScope);
  };
  KnowledgeBase.prototype.fulfill_z9vbnb$$default = function (query, randomVarsScope) {
    return query.findProofWithin_5dl3t6$(this, void 0, randomVarsScope);
  };
  KnowledgeBase.prototype.fulfill_z9vbnb$ = function (query, randomVarsScope, callback$default) {
    if (randomVarsScope === void 0)
      randomVarsScope = new RandomVariableScope();
    return callback$default ? callback$default(query, randomVarsScope) : this.fulfill_z9vbnb$$default(query, randomVarsScope);
  };
  function KnowledgeBase$Companion() {
    KnowledgeBase$Companion_instance = this;
    this.EMPTY = new EmptyKnowledgeBase();
  }
  KnowledgeBase$Companion.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'Companion',
    interfaces: []
  };
  var KnowledgeBase$Companion_instance = null;
  function KnowledgeBase$Companion_getInstance() {
    if (KnowledgeBase$Companion_instance === null) {
      new KnowledgeBase$Companion();
    }
    return KnowledgeBase$Companion_instance;
  }
  KnowledgeBase.$metadata$ = {
    kind: Kind_INTERFACE,
    simpleName: 'KnowledgeBase',
    interfaces: []
  };
  function MutableKnowledgeBase() {
  }
  MutableKnowledgeBase.$metadata$ = {
    kind: Kind_INTERFACE,
    simpleName: 'MutableKnowledgeBase',
    interfaces: [KnowledgeBase]
  };
  function EmptyKnowledgeBase() {
    this.operatorRegistry_ecpkum$_0 = EmptyOperatorRegistry_getInstance();
  }
  EmptyKnowledgeBase.prototype.fulfill_idmyxu$$default = function (predicate, randomVarsScope) {
    return Unification$Companion_getInstance().NONE;
  };
  Object.defineProperty(EmptyKnowledgeBase.prototype, 'operatorRegistry', {
    get: function () {
      return this.operatorRegistry_ecpkum$_0;
    }
  });
  EmptyKnowledgeBase.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'EmptyKnowledgeBase',
    interfaces: [KnowledgeBase]
  };
  function DefaultOperatorRegistry(withIsoOps) {
    this.operators_0 = LinkedHashMap_init();
    if (withIsoOps) {
      this.defineOperator_abg1pn$(new OperatorDefinition(1200, OperatorType$XFX_getInstance(), ':-'));
      this.defineOperator_abg1pn$(new OperatorDefinition(1200, OperatorType$FX_getInstance(), ':-'));
      this.defineOperator_abg1pn$(new OperatorDefinition(1200, OperatorType$FX_getInstance(), '?-'));
      this.defineOperator_abg1pn$(new OperatorDefinition(1150, OperatorType$FX_getInstance(), 'dynamic'));
      this.defineOperator_abg1pn$(new OperatorDefinition(1100, OperatorType$XFY_getInstance(), ';'));
      this.defineOperator_abg1pn$(new OperatorDefinition(1100, OperatorType$XFY_getInstance(), '|'));
      this.defineOperator_abg1pn$(new OperatorDefinition(1000, OperatorType$XFY_getInstance(), ','));
      this.defineOperator_abg1pn$(new OperatorDefinition(400, OperatorType$YFX_getInstance(), '/'));
    }
  }
  DefaultOperatorRegistry.prototype.getOperatorDefinitionsFor_61zpoe$ = function (name) {
    var tmp$;
    return (tmp$ = this.operators_0.get_11rb$(name)) != null ? tmp$ : emptySet();
  };
  DefaultOperatorRegistry.prototype.defineOperator_abg1pn$ = function (definition) {
    var targetSet = this.operators_0.get_11rb$(definition.name);
    if (targetSet == null) {
      targetSet = HashSet_init();
      var $receiver = this.operators_0;
      var key = definition.name;
      var value = targetSet;
      $receiver.put_xwzc9p$(key, value);
    }
    targetSet.add_11rb$(definition);
  };
  Object.defineProperty(DefaultOperatorRegistry.prototype, 'allOperators', {
    get: function () {
      return flatten(this.operators_0.values);
    }
  });
  var LinkedHashSet_init = Kotlin.kotlin.collections.LinkedHashSet_init_287e2$;
  DefaultOperatorRegistry.prototype.include_8ngtbf$ = function (other) {
    var tmp$;
    if (Kotlin.isType(other, DefaultOperatorRegistry)) {
      tmp$ = other.operators_0.keys.iterator();
      while (tmp$.hasNext()) {
        var name = tmp$.next();
        var $receiver = this.operators_0;
        var tmp$_0;
        if ((Kotlin.isType(tmp$_0 = $receiver, Map) ? tmp$_0 : throwCCE()).containsKey_11rb$(name)) {
          ensureNotNull(this.operators_0.get_11rb$(name)).addAll_brywnq$(ensureNotNull(other.operators_0.get_11rb$(name)));
        }
         else {
          var tmp$_1 = this.operators_0;
          var value = LinkedHashSet_init();
          tmp$_1.put_xwzc9p$(name, value);
        }
      }
    }
     else {
      MutableOperatorRegistry.prototype.include_8ngtbf$.call(this, other);
    }
  };
  DefaultOperatorRegistry.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'DefaultOperatorRegistry',
    interfaces: [MutableOperatorRegistry]
  };
  function DefaultOperatorRegistry_init($this) {
    $this = $this || Object.create(DefaultOperatorRegistry.prototype);
    DefaultOperatorRegistry.call($this, false);
    return $this;
  }
  function DoublyIndexedLibraryEntryStore() {
    this.index_0 = LinkedHashMap_init();
    this.indexChangedSinceLastExportsCalculation_0 = true;
    this.cachedExports_0 = null;
  }
  DoublyIndexedLibraryEntryStore.prototype.findFor_76kv2e$ = function (predicate) {
    var tmp$, tmp$_0;
    tmp$ = this.index_0.get_11rb$(predicate.name);
    if (tmp$ == null) {
      return emptyList();
    }
    var arityMap = tmp$;
    return (tmp$_0 = arityMap.get_za3lpa$(predicate.arity)) != null ? tmp$_0 : emptyList();
  };
  DoublyIndexedLibraryEntryStore.prototype.add_jkxsdx$ = function (entry) {
    var arityIndex;
    var $receiver = this.index_0;
    var key = entry.name;
    var tmp$;
    if (!(Kotlin.isType(tmp$ = $receiver, Map) ? tmp$ : throwCCE()).containsKey_11rb$(key)) {
      arityIndex = new ArityMap();
      var $receiver_0 = this.index_0;
      var key_0 = entry.name;
      var value = arityIndex;
      $receiver_0.put_xwzc9p$(key_0, value);
    }
     else {
      arityIndex = ensureNotNull(this.index_0.get_11rb$(entry.name));
    }
    var entryList;
    if (!arityIndex.contains_za3lpa$(entry.arity)) {
      entryList = ArrayList_init();
      arityIndex.set_wxm5ur$(entry.arity, entryList);
    }
     else {
      entryList = ensureNotNull(arityIndex.get_za3lpa$(entry.arity));
    }
    entryList.add_11rb$(entry);
    this.indexChangedSinceLastExportsCalculation_0 = true;
  };
  DoublyIndexedLibraryEntryStore.prototype.include_w13h4a$ = function (other) {
    var tmp$, tmp$_0;
    if (Kotlin.isType(other, DoublyIndexedLibraryEntryStore)) {
      tmp$ = other.index_0.entries.iterator();
      while (tmp$.hasNext()) {
        var tmp$_1 = tmp$.next();
        var name = tmp$_1.key;
        var othersArityMap = tmp$_1.value;
        var $receiver = this.index_0;
        var tmp$_2;
        if ((Kotlin.isType(tmp$_2 = $receiver, Map) ? tmp$_2 : throwCCE()).containsKey_11rb$(name)) {
          var thisArityMap = ensureNotNull(this.index_0.get_11rb$(name));
          tmp$_0 = othersArityMap.arities.iterator();
          while (tmp$_0.hasNext()) {
            var arity = tmp$_0.next();
            if (!thisArityMap.contains_za3lpa$(arity)) {
              thisArityMap.set_wxm5ur$(arity, ArrayList_init());
            }
            ensureNotNull(thisArityMap.get_za3lpa$(arity)).addAll_brywnq$(ensureNotNull(othersArityMap.get_za3lpa$(arity)));
          }
        }
         else {
          var $receiver_0 = this.index_0;
          var value = copy(othersArityMap);
          $receiver_0.put_xwzc9p$(name, value);
        }
      }
    }
     else {
      var $receiver_1 = other.exports;
      var action = getCallableRef('add', function ($receiver, entry) {
        return $receiver.add_jkxsdx$(entry), Unit;
      }.bind(null, this));
      var tmp$_3;
      tmp$_3 = $receiver_1.iterator();
      while (tmp$_3.hasNext()) {
        var element = tmp$_3.next();
        action(element);
      }
    }
    this.indexChangedSinceLastExportsCalculation_0 = true;
  };
  var addAll = Kotlin.kotlin.collections.addAll_ipc267$;
  Object.defineProperty(DoublyIndexedLibraryEntryStore.prototype, 'exports', {
    get: function () {
      if (this.indexChangedSinceLastExportsCalculation_0) {
        var $receiver = this.index_0;
        var destination = ArrayList_init();
        var tmp$;
        tmp$ = $receiver.entries.iterator();
        while (tmp$.hasNext()) {
          var element = tmp$.next();
          var $receiver_0 = element.value.arities;
          var destination_0 = ArrayList_init();
          var tmp$_0;
          tmp$_0 = $receiver_0.iterator();
          while (tmp$_0.hasNext()) {
            var element_0 = tmp$_0.next();
            var list = ensureNotNull(element.value.get_za3lpa$(element_0));
            addAll(destination_0, list);
          }
          var list_0 = destination_0;
          addAll(destination, list_0);
        }
        this.cachedExports_0 = destination;
        this.indexChangedSinceLastExportsCalculation_0 = false;
      }
      return ensureNotNull(this.cachedExports_0);
    }
  });
  function DoublyIndexedLibraryEntryStore$retractFact$lambda(closure$entryList, closure$fact) {
    return function () {
      var tmp$;
      tmp$ = closure$entryList.size;
      for (var index = 0; index < tmp$; index++) {
        var entry = closure$entryList.get_za3lpa$(index);
        if (Kotlin.isType(entry, Predicate)) {
          var unification = entry.unify_dtn93p$(closure$fact);
          if (unification != null) {
            closure$entryList.removeAt_za3lpa$(index);
            return unification;
          }
        }
      }
      return null;
    };
  }
  DoublyIndexedLibraryEntryStore.prototype.retractFact_76kv2e$ = function (fact) {
    var tmp$, tmp$_0;
    tmp$ = this.index_0.get_11rb$(fact.name);
    if (tmp$ == null) {
      return Unification$Companion_getInstance().NONE;
    }
    var arityIndex = tmp$;
    tmp$_0 = arityIndex.get_za3lpa$(fact.arity);
    if (tmp$_0 == null) {
      return Unification$Companion_getInstance().NONE;
    }
    var entryList = tmp$_0;
    return LazySequence$Companion_getInstance().fromGenerator_klfg04$(DoublyIndexedLibraryEntryStore$retractFact$lambda(entryList, fact));
  };
  function DoublyIndexedLibraryEntryStore$retract$lambda(closure$entryList, closure$unifiesWith) {
    return function () {
      var tmp$;
      tmp$ = closure$entryList.size;
      for (var index = 0; index < tmp$; index++) {
        var entry = closure$entryList.get_za3lpa$(index);
        if (Kotlin.isType(entry, Predicate)) {
          var unification = entry.unify_dtn93p$(closure$unifiesWith);
          if (unification != null) {
            closure$entryList.removeAt_za3lpa$(index);
            return unification;
          }
        }
         else if (Kotlin.isType(entry, Rule)) {
          var headUnification = entry.head.unify_dtn93p$(closure$unifiesWith);
          if (headUnification != null) {
            closure$entryList.removeAt_za3lpa$(index);
            return headUnification;
          }
        }
         else {
          throw new PrologRuntimeException('Cannot determine whether entry should be retracted: is neither a predicate nor a rule.');
        }
      }
      return null;
    };
  }
  DoublyIndexedLibraryEntryStore.prototype.retract_76kv2e$ = function (unifiesWith) {
    var tmp$, tmp$_0;
    tmp$ = this.index_0.get_11rb$(unifiesWith.name);
    if (tmp$ == null) {
      return Unification$Companion_getInstance().NONE;
    }
    var arityIndex = tmp$;
    tmp$_0 = arityIndex.get_za3lpa$(unifiesWith.arity);
    if (tmp$_0 == null) {
      return Unification$Companion_getInstance().NONE;
    }
    var entryList = tmp$_0;
    return LazySequence$Companion_getInstance().fromGenerator_klfg04$(DoublyIndexedLibraryEntryStore$retract$lambda(entryList, unifiesWith));
  };
  DoublyIndexedLibraryEntryStore.prototype.abolish_bm4lxs$ = function (functor, arity) {
    var tmp$;
    (tmp$ = this.index_0.get_11rb$(functor)) != null ? (tmp$.remove_za3lpa$(arity), Unit) : null;
  };
  DoublyIndexedLibraryEntryStore.prototype.abolishFacts_bm4lxs$ = function (functor, arity) {
    var tmp$, tmp$_0;
    tmp$ = this.index_0.get_11rb$(functor);
    if (tmp$ == null) {
      return;
    }
    var arityMap = tmp$;
    tmp$_0 = arityMap.get_za3lpa$(arity);
    if (tmp$_0 == null) {
      return;
    }
    var entryList = tmp$_0;
    var destination = ArrayList_init();
    var tmp$_1;
    tmp$_1 = entryList.iterator();
    while (tmp$_1.hasNext()) {
      var element = tmp$_1.next();
      if (Kotlin.isType(element, Predicate))
        destination.add_11rb$(element);
    }
    entryList.removeAll_brywnq$(destination);
  };
  DoublyIndexedLibraryEntryStore.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'DoublyIndexedLibraryEntryStore',
    interfaces: [MutableLibraryEntryStore]
  };
  function copy($receiver) {
    var array = Array_0($receiver.capacity + 1 | 0);
    var tmp$;
    tmp$ = array.length - 1 | 0;
    for (var i = 0; i <= tmp$; i++) {
      var listCopy = ArrayList_init();
      listCopy.addAll_brywnq$(ensureNotNull($receiver.get_za3lpa$(i)));
      array[i] = listCopy;
    }
    return new ArityMap(array);
  }
  function EmptyOperatorRegistry() {
    EmptyOperatorRegistry_instance = this;
    this.allOperators_txtwlk$_0 = emptySet();
  }
  Object.defineProperty(EmptyOperatorRegistry.prototype, 'allOperators', {
    get: function () {
      return this.allOperators_txtwlk$_0;
    }
  });
  EmptyOperatorRegistry.prototype.getOperatorDefinitionsFor_61zpoe$ = function (name) {
    return this.allOperators;
  };
  EmptyOperatorRegistry.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'EmptyOperatorRegistry',
    interfaces: [OperatorRegistry]
  };
  var EmptyOperatorRegistry_instance = null;
  function EmptyOperatorRegistry_getInstance() {
    if (EmptyOperatorRegistry_instance === null) {
      new EmptyOperatorRegistry();
    }
    return EmptyOperatorRegistry_instance;
  }
  function SimpleLibrary(entryStore, operatorRegistry) {
    this.entryStore_30a8ni$_0 = entryStore;
    this.operatorRegistry_ihzp34$_0 = operatorRegistry;
  }
  Object.defineProperty(SimpleLibrary.prototype, 'exports', {
    get: function () {
      return this.entryStore_30a8ni$_0.exports;
    }
  });
  SimpleLibrary.prototype.add_jkxsdx$ = function (entry) {
    this.entryStore_30a8ni$_0.add_jkxsdx$(entry);
  };
  Object.defineProperty(SimpleLibrary.prototype, 'allOperators', {
    get: function () {
      return this.operatorRegistry_ihzp34$_0.allOperators;
    }
  });
  SimpleLibrary.prototype.getOperatorDefinitionsFor_61zpoe$ = function (name) {
    return this.operatorRegistry_ihzp34$_0.getOperatorDefinitionsFor_61zpoe$(name);
  };
  SimpleLibrary.prototype.defineOperator_abg1pn$ = function (definition) {
    this.operatorRegistry_ihzp34$_0.defineOperator_abg1pn$(definition);
  };
  SimpleLibrary.prototype.retractFact_76kv2e$ = function (fact) {
    return this.entryStore_30a8ni$_0.retractFact_76kv2e$(fact);
  };
  SimpleLibrary.prototype.retract_76kv2e$ = function (unifiesWith) {
    return this.entryStore_30a8ni$_0.retract_76kv2e$(unifiesWith);
  };
  SimpleLibrary.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'SimpleLibrary',
    interfaces: [MutableLibrary]
  };
  function SimpleLibraryEntryStore(givenEntries) {
    if (givenEntries === void 0)
      givenEntries = emptyList();
    this.entries_0 = ArrayList_init_0(toList(givenEntries));
    this.exports_1i6bf$_0 = this.entries_0;
  }
  Object.defineProperty(SimpleLibraryEntryStore.prototype, 'exports', {
    get: function () {
      return this.exports_1i6bf$_0;
    }
  });
  SimpleLibraryEntryStore.prototype.add_jkxsdx$ = function (entry) {
    this.entries_0.add_11rb$(entry);
  };
  function SimpleLibraryEntryStore$retractFact$lambda(this$SimpleLibraryEntryStore, closure$fact) {
    return function () {
      var tmp$;
      tmp$ = this$SimpleLibraryEntryStore.entries_0.size;
      for (var index = 0; index < tmp$; index++) {
        var entry = this$SimpleLibraryEntryStore.entries_0.get_za3lpa$(index);
        if (Kotlin.isType(entry, Predicate)) {
          var unification = entry.unify_dtn93p$(closure$fact);
          if (unification != null) {
            this$SimpleLibraryEntryStore.entries_0.removeAt_za3lpa$(index);
            return unification;
          }
        }
      }
      return null;
    };
  }
  SimpleLibraryEntryStore.prototype.retractFact_76kv2e$ = function (fact) {
    return LazySequence$Companion_getInstance().fromGenerator_klfg04$(SimpleLibraryEntryStore$retractFact$lambda(this, fact));
  };
  function SimpleLibraryEntryStore$retract$lambda(this$SimpleLibraryEntryStore, closure$unifiesWith) {
    return function () {
      var tmp$;
      tmp$ = this$SimpleLibraryEntryStore.entries_0.size;
      for (var index = 0; index < tmp$; index++) {
        var entry = this$SimpleLibraryEntryStore.entries_0.get_za3lpa$(index);
        if (Kotlin.isType(entry, Predicate)) {
          var unification = entry.unify_dtn93p$(closure$unifiesWith);
          if (unification != null) {
            this$SimpleLibraryEntryStore.entries_0.removeAt_za3lpa$(index);
            return unification;
          }
        }
         else if (Kotlin.isType(entry, Rule)) {
          var headUnification = entry.head.unify_dtn93p$(closure$unifiesWith);
          if (headUnification != null) {
            this$SimpleLibraryEntryStore.entries_0.removeAt_za3lpa$(index);
            return headUnification;
          }
        }
         else {
          throw new PrologRuntimeException('Cannot test whether to retract an entry: is neither a fact nor a rule');
        }
      }
      return null;
    };
  }
  SimpleLibraryEntryStore.prototype.retract_76kv2e$ = function (unifiesWith) {
    return LazySequence$Companion_getInstance().fromGenerator_klfg04$(SimpleLibraryEntryStore$retract$lambda(this, unifiesWith));
  };
  SimpleLibraryEntryStore.prototype.abolishFacts_bm4lxs$ = function (functor, arity) {
    var tmp$ = this.entries_0;
    var $receiver = this.entries_0;
    var destination = ArrayList_init();
    var tmp$_0;
    tmp$_0 = $receiver.iterator();
    while (tmp$_0.hasNext()) {
      var element = tmp$_0.next();
      if (element.arity === arity && Kotlin.isType(element, Predicate) && equals(element.name, functor))
        destination.add_11rb$(element);
    }
    tmp$.removeAll_brywnq$(destination);
  };
  SimpleLibraryEntryStore.prototype.abolish_bm4lxs$ = function (functor, arity) {
    var tmp$ = this.entries_0;
    var $receiver = this.entries_0;
    var destination = ArrayList_init();
    var tmp$_0;
    tmp$_0 = $receiver.iterator();
    while (tmp$_0.hasNext()) {
      var element = tmp$_0.next();
      if (element.arity === arity && equals(element.name, functor))
        destination.add_11rb$(element);
    }
    tmp$.removeAll_brywnq$(destination);
  };
  SimpleLibraryEntryStore.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'SimpleLibraryEntryStore',
    interfaces: [MutableLibraryEntryStore]
  };
  function PredicatePrototype() {
  }
  function PredicatePrototype$asIdiomatic$ObjectLiteral(this$PredicatePrototype, name, arguments_0) {
    this.this$PredicatePrototype = this$PredicatePrototype;
    Predicate.call(this, name, arguments_0);
  }
  PredicatePrototype$asIdiomatic$ObjectLiteral.prototype.toString = function () {
    return this.this$PredicatePrototype.name + '/' + this.this$PredicatePrototype.arity;
  };
  PredicatePrototype$asIdiomatic$ObjectLiteral.$metadata$ = {
    kind: Kind_CLASS,
    interfaces: [Predicate]
  };
  PredicatePrototype.prototype.asIdiomatic = function () {
    return new PredicatePrototype$asIdiomatic$ObjectLiteral(this, '/', [new Atom(this.name), new Integer(Kotlin.Long.fromInt(this.arity))]);
  };
  PredicatePrototype.$metadata$ = {
    kind: Kind_INTERFACE,
    simpleName: 'PredicatePrototype',
    interfaces: []
  };
  function LibraryEntry() {
  }
  LibraryEntry.$metadata$ = {
    kind: Kind_INTERFACE,
    simpleName: 'LibraryEntry',
    interfaces: [PredicatePrototype]
  };
  function LibraryEntryStore() {
  }
  LibraryEntryStore.prototype.findFor_76kv2e$ = function (predicate) {
    var $receiver = this.exports;
    var destination = ArrayList_init();
    var tmp$;
    tmp$ = $receiver.iterator();
    while (tmp$.hasNext()) {
      var element = tmp$.next();
      if (element.arity === predicate.arity && equals(element.name, predicate.name))
        destination.add_11rb$(element);
    }
    return destination;
  };
  LibraryEntryStore.$metadata$ = {
    kind: Kind_INTERFACE,
    simpleName: 'LibraryEntryStore',
    interfaces: []
  };
  function MutableLibraryEntryStore() {
  }
  MutableLibraryEntryStore.prototype.include_w13h4a$ = function (other) {
    var $receiver = other.exports;
    var action = getCallableRef('add', function ($receiver, entry) {
      return $receiver.add_jkxsdx$(entry), Unit;
    }.bind(null, this));
    var tmp$;
    tmp$ = $receiver.iterator();
    while (tmp$.hasNext()) {
      var element = tmp$.next();
      action(element);
    }
  };
  MutableLibraryEntryStore.prototype.retractAllFacts_76kv2e$ = function (fact) {
    this.retractFact_76kv2e$(fact).consumeAll();
  };
  MutableLibraryEntryStore.prototype.retractAll_76kv2e$ = function (unifiesWith) {
    this.retract_76kv2e$(unifiesWith).consumeAll();
  };
  MutableLibraryEntryStore.prototype.abolishFacts_bm4lxs$ = function (functor, arity) {
    var tmp$ = this.retractAllFacts_76kv2e$;
    var array = Array_0(arity);
    var tmp$_0;
    tmp$_0 = array.length - 1 | 0;
    for (var i = 0; i <= tmp$_0; i++) {
      array[i] = Variable$Companion_getInstance().ANONYMOUS;
    }
    tmp$.call(this, new Predicate(functor, array));
  };
  MutableLibraryEntryStore.prototype.abolish_bm4lxs$ = function (functor, arity) {
    var tmp$ = this.retractAll_76kv2e$;
    var array = Array_0(arity);
    var tmp$_0;
    tmp$_0 = array.length - 1 | 0;
    for (var i = 0; i <= tmp$_0; i++) {
      array[i] = Variable$Companion_getInstance().ANONYMOUS;
    }
    tmp$.call(this, new Predicate(functor, array));
  };
  MutableLibraryEntryStore.$metadata$ = {
    kind: Kind_INTERFACE,
    simpleName: 'MutableLibraryEntryStore',
    interfaces: [LibraryEntryStore]
  };
  function OperatorRegistry() {
  }
  OperatorRegistry.$metadata$ = {
    kind: Kind_INTERFACE,
    simpleName: 'OperatorRegistry',
    interfaces: []
  };
  function MutableOperatorRegistry() {
  }
  MutableOperatorRegistry.prototype.include_8ngtbf$ = function (other) {
    var $receiver = other.allOperators;
    var action = getCallableRef('defineOperator', function ($receiver, definition) {
      return $receiver.defineOperator_abg1pn$(definition), Unit;
    }.bind(null, this));
    var tmp$;
    tmp$ = $receiver.iterator();
    while (tmp$.hasNext()) {
      var element = tmp$.next();
      action(element);
    }
  };
  MutableOperatorRegistry.$metadata$ = {
    kind: Kind_INTERFACE,
    simpleName: 'MutableOperatorRegistry',
    interfaces: [OperatorRegistry]
  };
  function OperatorDefinition(precedence, type, name) {
    this.precedence = precedence;
    this.type = type;
    this.name = name;
  }
  OperatorDefinition.prototype.toString = function () {
    return 'op(' + this.precedence + ', ' + this.type.name.toLowerCase() + ', ' + this.name + ')';
  };
  OperatorDefinition.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'OperatorDefinition',
    interfaces: []
  };
  OperatorDefinition.prototype.component1 = function () {
    return this.precedence;
  };
  OperatorDefinition.prototype.component2 = function () {
    return this.type;
  };
  OperatorDefinition.prototype.component3 = function () {
    return this.name;
  };
  OperatorDefinition.prototype.copy_bejbwh$ = function (precedence, type, name) {
    return new OperatorDefinition(precedence === void 0 ? this.precedence : precedence, type === void 0 ? this.type : type, name === void 0 ? this.name : name);
  };
  OperatorDefinition.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.precedence) | 0;
    result = result * 31 + Kotlin.hashCode(this.type) | 0;
    result = result * 31 + Kotlin.hashCode(this.name) | 0;
    return result;
  };
  OperatorDefinition.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && (Kotlin.equals(this.precedence, other.precedence) && Kotlin.equals(this.type, other.type) && Kotlin.equals(this.name, other.name)))));
  };
  function OperatorType(name, ordinal, arity) {
    Enum.call(this);
    this.arity = arity;
    this.name$ = name;
    this.ordinal$ = ordinal;
    this.isPrefix_rp15oe$_0 = lazy(OperatorType$isPrefix$lambda(this));
    this.isInfix_we54wg$_0 = lazy(OperatorType$isInfix$lambda(this));
    this.isPostfix_rnjma3$_0 = lazy(OperatorType$isPostfix$lambda(this));
  }
  function OperatorType_initFields() {
    OperatorType_initFields = function () {
    };
    OperatorType$FX_instance = new OperatorType('FX', 0, 1);
    OperatorType$FY_instance = new OperatorType('FY', 1, 1);
    OperatorType$XFX_instance = new OperatorType('XFX', 2, 2);
    OperatorType$XFY_instance = new OperatorType('XFY', 3, 2);
    OperatorType$YFX_instance = new OperatorType('YFX', 4, 2);
    OperatorType$XF_instance = new OperatorType('XF', 5, 1);
    OperatorType$YF_instance = new OperatorType('YF', 6, 1);
  }
  var OperatorType$FX_instance;
  function OperatorType$FX_getInstance() {
    OperatorType_initFields();
    return OperatorType$FX_instance;
  }
  var OperatorType$FY_instance;
  function OperatorType$FY_getInstance() {
    OperatorType_initFields();
    return OperatorType$FY_instance;
  }
  var OperatorType$XFX_instance;
  function OperatorType$XFX_getInstance() {
    OperatorType_initFields();
    return OperatorType$XFX_instance;
  }
  var OperatorType$XFY_instance;
  function OperatorType$XFY_getInstance() {
    OperatorType_initFields();
    return OperatorType$XFY_instance;
  }
  var OperatorType$YFX_instance;
  function OperatorType$YFX_getInstance() {
    OperatorType_initFields();
    return OperatorType$YFX_instance;
  }
  var OperatorType$XF_instance;
  function OperatorType$XF_getInstance() {
    OperatorType_initFields();
    return OperatorType$XF_instance;
  }
  var OperatorType$YF_instance;
  function OperatorType$YF_getInstance() {
    OperatorType_initFields();
    return OperatorType$YF_instance;
  }
  Object.defineProperty(OperatorType.prototype, 'isPrefix', {
    get: function () {
      var $receiver = this.isPrefix_rp15oe$_0;
      new PropertyMetadata('isPrefix');
      return $receiver.value;
    }
  });
  Object.defineProperty(OperatorType.prototype, 'isInfix', {
    get: function () {
      var $receiver = this.isInfix_we54wg$_0;
      new PropertyMetadata('isInfix');
      return $receiver.value;
    }
  });
  Object.defineProperty(OperatorType.prototype, 'isPostfix', {
    get: function () {
      var $receiver = this.isPostfix_rnjma3$_0;
      new PropertyMetadata('isPostfix');
      return $receiver.value;
    }
  });
  function OperatorType$isPrefix$lambda(this$OperatorType) {
    return function () {
      return this$OperatorType === OperatorType$FX_getInstance() || this$OperatorType === OperatorType$FY_getInstance();
    };
  }
  function OperatorType$isInfix$lambda(this$OperatorType) {
    return function () {
      return this$OperatorType === OperatorType$XFX_getInstance() || this$OperatorType === OperatorType$XFY_getInstance() || this$OperatorType === OperatorType$YFX_getInstance();
    };
  }
  function OperatorType$isPostfix$lambda(this$OperatorType) {
    return function () {
      return this$OperatorType === OperatorType$XF_getInstance() || this$OperatorType === OperatorType$YF_getInstance();
    };
  }
  OperatorType.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'OperatorType',
    interfaces: [Enum]
  };
  function OperatorType$values() {
    return [OperatorType$FX_getInstance(), OperatorType$FY_getInstance(), OperatorType$XFX_getInstance(), OperatorType$XFY_getInstance(), OperatorType$YFX_getInstance(), OperatorType$XF_getInstance(), OperatorType$YF_getInstance()];
  }
  OperatorType.values = OperatorType$values;
  function OperatorType$valueOf(name) {
    switch (name) {
      case 'FX':
        return OperatorType$FX_getInstance();
      case 'FY':
        return OperatorType$FY_getInstance();
      case 'XFX':
        return OperatorType$XFX_getInstance();
      case 'XFY':
        return OperatorType$XFY_getInstance();
      case 'YFX':
        return OperatorType$YFX_getInstance();
      case 'XF':
        return OperatorType$XF_getInstance();
      case 'YF':
        return OperatorType$YF_getInstance();
      default:throwISE('No enum constant com.github.prologdb.runtime.knowledge.library.OperatorType.' + name);
    }
  }
  OperatorType.valueOf_61zpoe$ = OperatorType$valueOf;
  function Library() {
  }
  Library.$metadata$ = {
    kind: Kind_INTERFACE,
    simpleName: 'Library',
    interfaces: [OperatorRegistry, LibraryEntryStore]
  };
  function MutableLibrary() {
  }
  MutableLibrary.prototype.include_5bfbyx$ = function (otherLibrary) {
    var tmp$, tmp$_0;
    this.include_w13h4a$(Kotlin.isType(tmp$ = otherLibrary, LibraryEntryStore) ? tmp$ : throwCCE());
    this.include_8ngtbf$(Kotlin.isType(tmp$_0 = otherLibrary, OperatorRegistry) ? tmp$_0 : throwCCE());
  };
  MutableLibrary.$metadata$ = {
    kind: Kind_INTERFACE,
    simpleName: 'MutableLibrary',
    interfaces: [MutableOperatorRegistry, MutableLibraryEntryStore, Library]
  };
  function DistinctLazySequence(base, selector) {
    this.base_0 = base;
    this.selector_0 = selector;
    this.keys = HashSet_init();
  }
  DistinctLazySequence.prototype.tryAdvance = function () {
    var tmp$;
    var baseValue;
    var key;
    do {
      tmp$ = this.base_0.tryAdvance();
      if (tmp$ == null) {
        return null;
      }
      baseValue = tmp$;
      key = this.selector_0(baseValue);
    }
     while (!this.keys.add_11rb$(key));
    return baseValue;
  };
  DistinctLazySequence.prototype.close = function () {
    this.base_0.close();
  };
  DistinctLazySequence.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'DistinctLazySequence',
    interfaces: [LazySequence]
  };
  function FilteredLazySequence(base, predicate) {
    this.base_0 = base;
    this.predicate_0 = predicate;
  }
  FilteredLazySequence.prototype.tryAdvance = function () {
    return find(this.base_0, this.predicate_0);
  };
  FilteredLazySequence.prototype.close = function () {
    this.base_0.close();
  };
  FilteredLazySequence.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'FilteredLazySequence',
    interfaces: [LazySequence]
  };
  function LazySequence() {
    LazySequence$Companion_getInstance();
  }
  function LazySequence$distinct$lambda(it) {
    return it;
  }
  LazySequence.prototype.distinct = function () {
    return this.distinctBy_2o04qz$(LazySequence$distinct$lambda);
  };
  LazySequence.prototype.distinctBy_2o04qz$ = function (selector) {
    return new DistinctLazySequence(this, selector);
  };
  LazySequence.prototype.foldRemaining_b8xf17$ = function (initial, accumulator) {
    var carry = {v: initial};
    var tmp$;
    while (true) {
      tmp$ = this.tryAdvance();
      if (tmp$ == null) {
        break;
      }
      carry.v = accumulator(carry.v, tmp$);
    }
    this.close();
    return carry.v;
  };
  LazySequence.prototype.minWith_h0x69c$ = function (comparator) {
    var tmp$;
    tmp$ = this.tryAdvance();
    if (tmp$ == null) {
      return null;
    }
    var pivot = {v: tmp$};
    var tmp$_0;
    while (true) {
      tmp$_0 = this.tryAdvance();
      if (tmp$_0 == null) {
        break;
      }
      if (comparator.compare(tmp$_0, pivot.v) < 0) {
        pivot.v = tmp$_0;
      }
    }
    this.close();
    return pivot.v;
  };
  LazySequence.prototype.minBy_mt9pj$ = function (selector) {
    var tmp$;
    tmp$ = this.tryAdvance();
    if (tmp$ == null) {
      return null;
    }
    var pivot = {v: tmp$};
    var pivotKey = {v: selector(pivot.v)};
    var tmp$_0;
    while (true) {
      tmp$_0 = this.tryAdvance();
      if (tmp$_0 == null) {
        break;
      }
      var elKey = selector(tmp$_0);
      if (Kotlin.compareTo(elKey, pivotKey.v) < 0) {
        pivot.v = tmp$_0;
        pivotKey.v = elKey;
      }
    }
    this.close();
    return pivot.v;
  };
  LazySequence.prototype.minByWith_ignqx2$ = function (selector, comparator) {
    var tmp$;
    tmp$ = this.tryAdvance();
    if (tmp$ == null) {
      return null;
    }
    var pivot = {v: tmp$};
    var pivotKey = {v: selector(pivot.v)};
    var tmp$_0;
    while (true) {
      tmp$_0 = this.tryAdvance();
      if (tmp$_0 == null) {
        break;
      }
      var elKey = selector(tmp$_0);
      if (comparator.compare(elKey, pivotKey.v) < 0) {
        pivot.v = tmp$_0;
        pivotKey.v = elKey;
      }
    }
    this.close();
    return pivot.v;
  };
  LazySequence.prototype.maxWith_h0x69c$ = function (comparator) {
    var tmp$;
    tmp$ = this.tryAdvance();
    if (tmp$ == null) {
      return null;
    }
    var pivot = {v: tmp$};
    var tmp$_0;
    while (true) {
      tmp$_0 = this.tryAdvance();
      if (tmp$_0 == null) {
        break;
      }
      if (comparator.compare(tmp$_0, pivot.v) > 0) {
        pivot.v = tmp$_0;
      }
    }
    this.close();
    return pivot.v;
  };
  LazySequence.prototype.maxBy_mt9pj$ = function (selector) {
    var tmp$;
    tmp$ = this.tryAdvance();
    if (tmp$ == null) {
      return null;
    }
    var pivot = {v: tmp$};
    var pivotKey = {v: selector(pivot.v)};
    var tmp$_0;
    while (true) {
      tmp$_0 = this.tryAdvance();
      if (tmp$_0 == null) {
        break;
      }
      var elKey = selector(tmp$_0);
      if (Kotlin.compareTo(elKey, pivotKey.v) < 0) {
        pivot.v = tmp$_0;
        pivotKey.v = elKey;
      }
    }
    this.close();
    return pivot.v;
  };
  LazySequence.prototype.maxByWith_ignqx2$ = function (selector, comparator) {
    var tmp$;
    tmp$ = this.tryAdvance();
    if (tmp$ == null) {
      return null;
    }
    var pivot = {v: tmp$};
    var pivotKey = {v: selector(pivot.v)};
    var tmp$_0;
    while (true) {
      tmp$_0 = this.tryAdvance();
      if (tmp$_0 == null) {
        break;
      }
      var elKey = selector(tmp$_0);
      if (comparator.compare(elKey, pivotKey.v) > 0) {
        pivot.v = tmp$_0;
        pivotKey.v = elKey;
      }
    }
    this.close();
    return pivot.v;
  };
  LazySequence.prototype.skip_za3lpa$ = function (n) {
    var skipped = 0;
    for (var i = 1; i <= n; i++) {
      if (this.tryAdvance() == null)
        break;
      skipped = skipped + 1 | 0;
    }
    return skipped;
  };
  LazySequence.prototype.consumeAll = function () {
    while (this.tryAdvance() != null) {
    }
  };
  function LazySequence$Companion() {
    LazySequence$Companion_instance = this;
    this.emptySequence_0 = new LazySequence$Companion$emptySequence$ObjectLiteral();
  }
  function LazySequence$Companion$of$ObjectLiteral(closure$elements) {
    this.closure$elements = closure$elements;
    this.index_0 = 0;
    this.closed_0 = false;
  }
  LazySequence$Companion$of$ObjectLiteral.prototype.tryAdvance = function () {
    var tmp$;
    if (this.closed_0 || this.index_0 >= this.closure$elements.length)
      return null;
    return this.closure$elements[tmp$ = this.index_0, this.index_0 = tmp$ + 1 | 0, tmp$];
  };
  LazySequence$Companion$of$ObjectLiteral.prototype.close = function () {
    this.closed_0 = true;
  };
  LazySequence$Companion$of$ObjectLiteral.$metadata$ = {
    kind: Kind_CLASS,
    interfaces: [LazySequence]
  };
  LazySequence$Companion.prototype.of_i5x0yv$ = function (elements) {
    if (elements.length === 0)
      return this.empty_287e2$();
    return new LazySequence$Companion$of$ObjectLiteral(elements);
  };
  function LazySequence$Companion$fromGenerator$ObjectLiteral(closure$generator) {
    this.closure$generator = closure$generator;
    this.closed = false;
  }
  LazySequence$Companion$fromGenerator$ObjectLiteral.prototype.tryAdvance = function () {
    if (this.closed)
      return null;
    var result = this.closure$generator();
    if (result == null)
      this.closed = true;
    return result;
  };
  LazySequence$Companion$fromGenerator$ObjectLiteral.prototype.close = function () {
    this.closed = true;
  };
  LazySequence$Companion$fromGenerator$ObjectLiteral.$metadata$ = {
    kind: Kind_CLASS,
    interfaces: [LazySequence]
  };
  LazySequence$Companion.prototype.fromGenerator_klfg04$ = function (generator) {
    return new LazySequence$Companion$fromGenerator$ObjectLiteral(generator);
  };
  LazySequence$Companion.prototype.empty_287e2$ = function () {
    var tmp$;
    return Kotlin.isType(tmp$ = this.emptySequence_0, LazySequence) ? tmp$ : throwCCE();
  };
  function LazySequence$Companion$emptySequence$ObjectLiteral() {
  }
  LazySequence$Companion$emptySequence$ObjectLiteral.prototype.tryAdvance = function () {
    return null;
  };
  LazySequence$Companion$emptySequence$ObjectLiteral.prototype.close = function () {
  };
  LazySequence$Companion$emptySequence$ObjectLiteral.$metadata$ = {
    kind: Kind_CLASS,
    interfaces: [LazySequence]
  };
  LazySequence$Companion.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'Companion',
    interfaces: []
  };
  var LazySequence$Companion_instance = null;
  function LazySequence$Companion_getInstance() {
    if (LazySequence$Companion_instance === null) {
      new LazySequence$Companion();
    }
    return LazySequence$Companion_instance;
  }
  LazySequence.$metadata$ = {
    kind: Kind_INTERFACE,
    simpleName: 'LazySequence',
    interfaces: []
  };
  function remainingTo($receiver, supplier) {
    var target = supplier();
    var tmp$;
    while (true) {
      tmp$ = $receiver.tryAdvance();
      if (tmp$ == null) {
        break;
      }
      target.add_11rb$(tmp$);
    }
    $receiver.close();
    return target;
  }
  function find($receiver, predicate) {
    var tmp$;
    var baseResult;
    var predicateResult;
    do {
      tmp$ = $receiver.tryAdvance();
      if (tmp$ == null) {
        return null;
      }
      baseResult = tmp$;
      predicateResult = predicate(baseResult);
    }
     while (!predicateResult);
    return predicateResult ? baseResult : null;
  }
  function filterRemainingNotNull$lambda(it) {
    return it != null;
  }
  function filterRemainingNotNull($receiver) {
    var tmp$;
    return Kotlin.isType(tmp$ = new FilteredLazySequence($receiver, filterRemainingNotNull$lambda), LazySequence) ? tmp$ : throwCCE();
  }
  function filterRemaining($receiver, predicate) {
    return new FilteredLazySequence($receiver, predicate);
  }
  function mapRemaining($receiver, mapper) {
    return new MappedLazySequence($receiver, mapper);
  }
  var forEachRemaining = defineInlineFunction('runtime-core-js.com.github.prologdb.runtime.lazysequence.forEachRemaining_pg9z47$', function ($receiver, consumer) {
    var tmp$;
    while (true) {
      tmp$ = $receiver.tryAdvance();
      if (tmp$ == null) {
        break;
      }
      consumer(tmp$);
    }
    $receiver.close();
  });
  function LazySequenceBuilder(searchFun) {
    this.sequenceImpl_0 = new LazySequenceBuilder$SequenceImpl(this);
    this.continuation_0 = createCoroutine(searchFun, this, this.sequenceImpl_0.onComplete_8be2vx$);
    this.sequence = this.sequenceImpl_0;
  }
  function LazySequenceBuilder$SequenceState(name, ordinal) {
    Enum.call(this);
    this.name$ = name;
    this.ordinal$ = ordinal;
  }
  function LazySequenceBuilder$SequenceState_initFields() {
    LazySequenceBuilder$SequenceState_initFields = function () {
    };
    LazySequenceBuilder$SequenceState$INITIAL_instance = new LazySequenceBuilder$SequenceState('INITIAL', 0);
    LazySequenceBuilder$SequenceState$ELEMENT_AVAILABLE_instance = new LazySequenceBuilder$SequenceState('ELEMENT_AVAILABLE', 1);
    LazySequenceBuilder$SequenceState$SUBSEQUENCE_AVAILABLE_instance = new LazySequenceBuilder$SequenceState('SUBSEQUENCE_AVAILABLE', 2);
    LazySequenceBuilder$SequenceState$AFTER_SUBSEQUENCE_instance = new LazySequenceBuilder$SequenceState('AFTER_SUBSEQUENCE', 3);
    LazySequenceBuilder$SequenceState$COMPLETED_instance = new LazySequenceBuilder$SequenceState('COMPLETED', 4);
    LazySequenceBuilder$SequenceState$ERRORED_instance = new LazySequenceBuilder$SequenceState('ERRORED', 5);
  }
  var LazySequenceBuilder$SequenceState$INITIAL_instance;
  function LazySequenceBuilder$SequenceState$INITIAL_getInstance() {
    LazySequenceBuilder$SequenceState_initFields();
    return LazySequenceBuilder$SequenceState$INITIAL_instance;
  }
  var LazySequenceBuilder$SequenceState$ELEMENT_AVAILABLE_instance;
  function LazySequenceBuilder$SequenceState$ELEMENT_AVAILABLE_getInstance() {
    LazySequenceBuilder$SequenceState_initFields();
    return LazySequenceBuilder$SequenceState$ELEMENT_AVAILABLE_instance;
  }
  var LazySequenceBuilder$SequenceState$SUBSEQUENCE_AVAILABLE_instance;
  function LazySequenceBuilder$SequenceState$SUBSEQUENCE_AVAILABLE_getInstance() {
    LazySequenceBuilder$SequenceState_initFields();
    return LazySequenceBuilder$SequenceState$SUBSEQUENCE_AVAILABLE_instance;
  }
  var LazySequenceBuilder$SequenceState$AFTER_SUBSEQUENCE_instance;
  function LazySequenceBuilder$SequenceState$AFTER_SUBSEQUENCE_getInstance() {
    LazySequenceBuilder$SequenceState_initFields();
    return LazySequenceBuilder$SequenceState$AFTER_SUBSEQUENCE_instance;
  }
  var LazySequenceBuilder$SequenceState$COMPLETED_instance;
  function LazySequenceBuilder$SequenceState$COMPLETED_getInstance() {
    LazySequenceBuilder$SequenceState_initFields();
    return LazySequenceBuilder$SequenceState$COMPLETED_instance;
  }
  var LazySequenceBuilder$SequenceState$ERRORED_instance;
  function LazySequenceBuilder$SequenceState$ERRORED_getInstance() {
    LazySequenceBuilder$SequenceState_initFields();
    return LazySequenceBuilder$SequenceState$ERRORED_instance;
  }
  LazySequenceBuilder$SequenceState.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'SequenceState',
    interfaces: [Enum]
  };
  function LazySequenceBuilder$SequenceState$values() {
    return [LazySequenceBuilder$SequenceState$INITIAL_getInstance(), LazySequenceBuilder$SequenceState$ELEMENT_AVAILABLE_getInstance(), LazySequenceBuilder$SequenceState$SUBSEQUENCE_AVAILABLE_getInstance(), LazySequenceBuilder$SequenceState$AFTER_SUBSEQUENCE_getInstance(), LazySequenceBuilder$SequenceState$COMPLETED_getInstance(), LazySequenceBuilder$SequenceState$ERRORED_getInstance()];
  }
  LazySequenceBuilder$SequenceState.values = LazySequenceBuilder$SequenceState$values;
  function LazySequenceBuilder$SequenceState$valueOf(name) {
    switch (name) {
      case 'INITIAL':
        return LazySequenceBuilder$SequenceState$INITIAL_getInstance();
      case 'ELEMENT_AVAILABLE':
        return LazySequenceBuilder$SequenceState$ELEMENT_AVAILABLE_getInstance();
      case 'SUBSEQUENCE_AVAILABLE':
        return LazySequenceBuilder$SequenceState$SUBSEQUENCE_AVAILABLE_getInstance();
      case 'AFTER_SUBSEQUENCE':
        return LazySequenceBuilder$SequenceState$AFTER_SUBSEQUENCE_getInstance();
      case 'COMPLETED':
        return LazySequenceBuilder$SequenceState$COMPLETED_getInstance();
      case 'ERRORED':
        return LazySequenceBuilder$SequenceState$ERRORED_getInstance();
      default:throwISE('No enum constant com.github.prologdb.runtime.lazysequence.LazySequenceBuilder.SequenceState.' + name);
    }
  }
  LazySequenceBuilder$SequenceState.valueOf_61zpoe$ = LazySequenceBuilder$SequenceState$valueOf;
  function LazySequenceBuilder$SequenceImpl($outer) {
    this.$outer = $outer;
    this.state = LazySequenceBuilder$SequenceState$INITIAL_getInstance();
    this.currentElement = null;
    this.currentSubSequence = null;
    this.exception = null;
    this.mutex = new Any();
    this.onComplete_8be2vx$ = new LazySequenceBuilder$SequenceImpl$onComplete$ObjectLiteral(this);
  }
  Object.defineProperty(LazySequenceBuilder$SequenceImpl.prototype, 'isCompleted', {
    get: function () {
      return this.state === LazySequenceBuilder$SequenceState$COMPLETED_getInstance() || this.state === LazySequenceBuilder$SequenceState$ERRORED_getInstance();
    }
  });
  LazySequenceBuilder$SequenceImpl.prototype.onElementAvailable_1c3m6u$ = function (element) {
    this.currentElement = element;
    this.state = LazySequenceBuilder$SequenceState$ELEMENT_AVAILABLE_getInstance();
    this.currentSubSequence = null;
  };
  LazySequenceBuilder$SequenceImpl.prototype.onSubSequenceAvailable_vnv4me$ = function (sequence) {
    this.currentSubSequence = sequence;
    this.state = LazySequenceBuilder$SequenceState$SUBSEQUENCE_AVAILABLE_getInstance();
    this.currentElement = null;
  };
  LazySequenceBuilder$SequenceImpl.prototype.tryAdvance = function () {
    this.$outer;
    var this$LazySequenceBuilder = this.$outer;
    var tmp$, tmp$_0, tmp$_1;
    if (this.isCompleted)
      return null;
    if (this.state === LazySequenceBuilder$SequenceState$SUBSEQUENCE_AVAILABLE_getInstance()) {
      var result = ensureNotNull(this.currentSubSequence).tryAdvance();
      if (result != null) {
        return result;
      }
      this.state = LazySequenceBuilder$SequenceState$AFTER_SUBSEQUENCE_getInstance();
      this.currentSubSequence = null;
    }
    this$LazySequenceBuilder.continuation_0.resume_11rb$(Unit);
    tmp$ = this.state;
    if (equals(tmp$, LazySequenceBuilder$SequenceState$ELEMENT_AVAILABLE_getInstance()))
      tmp$_1 = this.currentElement;
    else if (equals(tmp$, LazySequenceBuilder$SequenceState$COMPLETED_getInstance()))
      tmp$_1 = null;
    else if (equals(tmp$, LazySequenceBuilder$SequenceState$SUBSEQUENCE_AVAILABLE_getInstance()))
      tmp$_1 = this.tryAdvance();
    else if (equals(tmp$, LazySequenceBuilder$SequenceState$ERRORED_getInstance()))
      throw (tmp$_0 = this.exception) != null ? tmp$_0 : new IllegalStateException();
    else if (equals(tmp$, LazySequenceBuilder$SequenceState$AFTER_SUBSEQUENCE_getInstance()))
      throw new IllegalStateException();
    else if (equals(tmp$, LazySequenceBuilder$SequenceState$INITIAL_getInstance()))
      throw new IllegalStateException();
    else
      tmp$_1 = Kotlin.noWhenBranchMatched();
    return tmp$_1;
  };
  LazySequenceBuilder$SequenceImpl.prototype.close = function () {
    this.state = LazySequenceBuilder$SequenceState$COMPLETED_getInstance();
    this.currentElement = null;
    this.currentSubSequence = null;
  };
  function LazySequenceBuilder$SequenceImpl$onComplete$ObjectLiteral(this$SequenceImpl) {
    this.this$SequenceImpl = this$SequenceImpl;
    this.context_32milz$_0 = experimental.EmptyCoroutineContext;
  }
  Object.defineProperty(LazySequenceBuilder$SequenceImpl$onComplete$ObjectLiteral.prototype, 'context', {
    get: function () {
      return this.context_32milz$_0;
    }
  });
  LazySequenceBuilder$SequenceImpl$onComplete$ObjectLiteral.prototype.resume_11rb$ = function (value) {
    this.this$SequenceImpl;
    this.this$SequenceImpl;
    var this$SequenceImpl = this.this$SequenceImpl;
    if (this$SequenceImpl.isCompleted)
      throw new IllegalStateException();
    this$SequenceImpl.close();
  };
  LazySequenceBuilder$SequenceImpl$onComplete$ObjectLiteral.prototype.resumeWithException_tcv7n7$ = function (exception) {
    this.this$SequenceImpl;
    this.this$SequenceImpl;
    var this$SequenceImpl = this.this$SequenceImpl;
    if (this$SequenceImpl.isCompleted)
      throw new IllegalStateException();
    this$SequenceImpl.exception = exception;
    this$SequenceImpl.state = LazySequenceBuilder$SequenceState$ERRORED_getInstance();
    this$SequenceImpl.currentElement = null;
    this$SequenceImpl.currentSubSequence = null;
  };
  LazySequenceBuilder$SequenceImpl$onComplete$ObjectLiteral.$metadata$ = {
    kind: Kind_CLASS,
    interfaces: [Continuation]
  };
  LazySequenceBuilder$SequenceImpl.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'SequenceImpl',
    interfaces: [LazySequence]
  };
  function LazySequenceBuilder$yield$lambda(this$LazySequenceBuilder) {
    return function (it) {
      this$LazySequenceBuilder.continuation_0 = it;
      return Unit;
    };
  }
  var SafeContinuation_init = Kotlin.kotlin.coroutines.experimental.SafeContinuation_init_n4f53e$;
  function suspendCoroutine$lambda(closure$block) {
    return function (c) {
      var safe = SafeContinuation_init(c);
      closure$block(safe);
      return safe.getResult();
    };
  }
  LazySequenceBuilder.prototype.yield_11rb$ = function (element_0, continuation_0, suspended) {
    var instance = new Coroutine$yield_11rb$(this, element_0, continuation_0);
    if (suspended)
      return instance;
    else
      return instance.doResume(null);
  };
  function Coroutine$yield_11rb$($this, element_0, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.exceptionState_0 = 1;
    this.$this = $this;
    this.local$element = element_0;
  }
  Coroutine$yield_11rb$.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$yield_11rb$.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$yield_11rb$.prototype.constructor = Coroutine$yield_11rb$;
  Coroutine$yield_11rb$.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.$this.sequenceImpl_0.onElementAvailable_1c3m6u$(this.local$element);
            this.result_0 = suspendCoroutine$lambda(LazySequenceBuilder$yield$lambda(this.$this))(this.facade);
            return;
          case 1:
            throw this.exception_0;
        }
      }
       catch (e) {
        if (this.state_0 === 1)
          throw e;
        else {
          this.state_0 = this.exceptionState_0;
          this.exception_0 = e;
        }
      }
     while (true);
  };
  function LazySequenceBuilder$yieldAll$lambda(this$LazySequenceBuilder) {
    return function (it) {
      this$LazySequenceBuilder.continuation_0 = it;
      return Unit;
    };
  }
  function suspendCoroutine$lambda_0(closure$block) {
    return function (c) {
      var safe = SafeContinuation_init(c);
      closure$block(safe);
      return safe.getResult();
    };
  }
  LazySequenceBuilder.prototype.yieldAll_481s4d$ = function (sequence_0, continuation_0, suspended) {
    var instance = new Coroutine$yieldAll_481s4d$(this, sequence_0, continuation_0);
    if (suspended)
      return instance;
    else
      return instance.doResume(null);
  };
  function Coroutine$yieldAll_481s4d$($this, sequence_0, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.exceptionState_0 = 1;
    this.$this = $this;
    this.local$sequence = sequence_0;
  }
  Coroutine$yieldAll_481s4d$.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$yieldAll_481s4d$.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$yieldAll_481s4d$.prototype.constructor = Coroutine$yieldAll_481s4d$;
  Coroutine$yieldAll_481s4d$.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.$this.sequenceImpl_0.onSubSequenceAvailable_vnv4me$(this.local$sequence);
            this.result_0 = suspendCoroutine$lambda_0(LazySequenceBuilder$yieldAll$lambda(this.$this))(this.facade);
            return;
          case 1:
            throw this.exception_0;
        }
      }
       catch (e) {
        if (this.state_0 === 1)
          throw e;
        else {
          this.state_0 = this.exceptionState_0;
          this.exception_0 = e;
        }
      }
     while (true);
  };
  LazySequenceBuilder.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'LazySequenceBuilder',
    interfaces: []
  };
  function buildLazySequence(searchFun) {
    return (new LazySequenceBuilder(searchFun)).sequence;
  }
  function MappedLazySequence(base, mapper) {
    this.base_0 = base;
    this.mapper_0 = mapper;
  }
  MappedLazySequence.prototype.tryAdvance = function () {
    var tmp$;
    tmp$ = this.base_0.tryAdvance();
    if (tmp$ == null) {
      return null;
    }
    var el = tmp$;
    return this.mapper_0(el);
  };
  MappedLazySequence.prototype.close = function () {
    this.base_0.close();
  };
  MappedLazySequence.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'MappedLazySequence',
    interfaces: [LazySequence]
  };
  function AndQuery(goals) {
    this.goals = goals;
  }
  function AndQuery$findProofWithin$lambda(closure$substitutedGoals_0, closure$kb_0, closure$randomVarsScope_0, closure$initialVariables_0, this$AndQuery_0) {
    return function ($receiver_0, continuation_0, suspended) {
      var instance = new Coroutine$AndQuery$findProofWithin$lambda(closure$substitutedGoals_0, closure$kb_0, closure$randomVarsScope_0, closure$initialVariables_0, this$AndQuery_0, $receiver_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function Coroutine$AndQuery$findProofWithin$lambda(closure$substitutedGoals_0, closure$kb_0, closure$randomVarsScope_0, closure$initialVariables_0, this$AndQuery_0, $receiver_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$substitutedGoals = closure$substitutedGoals_0;
    this.local$closure$kb = closure$kb_0;
    this.local$closure$randomVarsScope = closure$randomVarsScope_0;
    this.local$closure$initialVariables = closure$initialVariables_0;
    this.local$this$AndQuery = this$AndQuery_0;
    this.local$$receiver = $receiver_0;
  }
  Coroutine$AndQuery$findProofWithin$lambda.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$AndQuery$findProofWithin$lambda.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$AndQuery$findProofWithin$lambda.prototype.constructor = Coroutine$AndQuery$findProofWithin$lambda;
  Coroutine$AndQuery$findProofWithin$lambda.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.state_0 = 2;
            this.result_0 = this.local$this$AndQuery.fulfillAllGoals_wy1dm9$_0(this.local$$receiver, this.local$closure$substitutedGoals, this.local$closure$kb, this.local$closure$randomVarsScope, this.local$closure$initialVariables.copy(), this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            break;
          case 1:
            throw this.exception_0;
          case 2:
            return this.result_0;
        }
      }
       catch (e) {
        if (this.state_0 === 1)
          throw e;
        else {
          this.state_0 = this.exceptionState_0;
          this.exception_0 = e;
        }
      }
     while (true);
  };
  AndQuery.prototype.findProofWithin_5dl3t6$$default = function (kb, initialVariables, randomVarsScope) {
    var $receiver = this.goals;
    var destination = ArrayList_init($receiver.length);
    var tmp$;
    for (tmp$ = 0; tmp$ !== $receiver.length; ++tmp$) {
      var item = $receiver[tmp$];
      destination.add_11rb$(item.substituteVariables_t6ifwg$(initialVariables));
    }
    var substitutedGoals = destination;
    return buildLazySequence(AndQuery$findProofWithin$lambda(substitutedGoals, kb, randomVarsScope, initialVariables, this));
  };
  AndQuery.prototype.withRandomVariables_fixsiv$ = function (randomVarsScope, mapping) {
    var $receiver = this.goals;
    var array = Array_0($receiver.length);
    var tmp$;
    tmp$ = array.length - 1 | 0;
    for (var i = 0; i <= tmp$; i++) {
      array[i] = $receiver[i].withRandomVariables_fixsiv$(randomVarsScope, mapping);
    }
    return new AndQuery(array);
  };
  AndQuery.prototype.substituteVariables_t6ifwg$ = function (variableValues) {
    var $receiver = this.goals;
    var array = Array_0($receiver.length);
    var tmp$;
    tmp$ = array.length - 1 | 0;
    for (var i = 0; i <= tmp$; i++) {
      array[i] = $receiver[i].substituteVariables_t6ifwg$(variableValues);
    }
    return new AndQuery(array);
  };
  AndQuery.prototype.toString = function () {
    var $receiver = this.goals;
    var array = Array_0($receiver.length);
    var tmp$;
    tmp$ = array.length - 1 | 0;
    for (var i = 0; i <= tmp$; i++) {
      array[i] = $receiver[i].toString();
    }
    return joinToString_0(array, ', ');
  };
  AndQuery.prototype.fulfillAllGoals_wy1dm9$_0 = function ($receiver_0, goals_0, kb_0, randomVarsScope_0, vars_0, continuation_0, suspended) {
    var instance = new Coroutine$fulfillAllGoals_wy1dm9$_0(this, $receiver_0, goals_0, kb_0, randomVarsScope_0, vars_0, continuation_0);
    if (suspended)
      return instance;
    else
      return instance.doResume(null);
  };
  function Coroutine$fulfillAllGoals_wy1dm9$_0($this, $receiver_0, goals_0, kb_0, randomVarsScope_0, vars_0, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.exceptionState_0 = 1;
    this.$this = $this;
    this.local$$receiver = void 0;
    this.local$tmp$ = void 0;
    this.local$closure$continuation = void 0;
    this.local$tmp$_0 = void 0;
    this.local$goalVars = void 0;
    this.local$$receiver_0 = $receiver_0;
    this.local$goals = goals_0;
    this.local$kb = kb_0;
    this.local$randomVarsScope = randomVarsScope_0;
    this.local$vars = vars_0;
  }
  Coroutine$fulfillAllGoals_wy1dm9$_0.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$fulfillAllGoals_wy1dm9$_0.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$fulfillAllGoals_wy1dm9$_0.prototype.constructor = Coroutine$fulfillAllGoals_wy1dm9$_0;
  Coroutine$fulfillAllGoals_wy1dm9$_0.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            if (this.local$vars === void 0)
              this.local$vars = VariableBucket_init();
            var goal = this.local$goals.get_za3lpa$(0).substituteVariables_t6ifwg$(this.local$vars);
            this.local$$receiver = this.local$kb.fulfill_z9vbnb$(goal, this.local$randomVarsScope);
            this.state_0 = 2;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            this.local$tmp$ = this.local$$receiver.tryAdvance();
            if (this.local$tmp$ == null) {
              this.state_0 = 14;
              continue;
            }
             else {
              this.state_0 = 3;
              continue;
            }

          case 3:
            this.local$closure$continuation = this;
            this.state_0 = 4;
            continue;
          case 4:
            var tmp$;
            this.local$goalVars = this.local$vars.copy();
            this.local$tmp$_0 = this.local$tmp$.variableValues.values.iterator();
            this.state_0 = 5;
            continue;
          case 5:
            if (!this.local$tmp$_0.hasNext()) {
              this.state_0 = 9;
              continue;
            }

            var tmp$_0 = this.local$tmp$_0.next();
            var variable = tmp$_0.component1()
            , value = tmp$_0.component2();
            if (value != null) {
              var substitutedValue = value.substituteVariables_6ryr4$(this.local$goalVars.asSubstitutionMapper());
              if (this.local$goalVars.isInstantiated_cua0ab$(variable)) {
                if (!((tmp$ = this.local$goalVars.get_cua0ab$(variable)) != null ? tmp$.equals(substitutedValue) : null) && !equals(this.local$goalVars.get_cua0ab$(variable), value)) {
                  this.state_0 = 13;
                  continue;
                }
                 else {
                  this.state_0 = 6;
                  continue;
                }
              }
               else {
                this.local$goalVars.instantiate_hg6dwi$(variable, substitutedValue);
                this.state_0 = 7;
                continue;
              }
            }
             else {
              this.state_0 = 8;
              continue;
            }

          case 6:
            this.state_0 = 7;
            continue;
          case 7:
            this.state_0 = 8;
            continue;
          case 8:
            this.state_0 = 5;
            continue;
          case 9:
            if (this.local$goals.size === 1) {
              this.state_0 = 11;
              this.result_0 = this.local$$receiver_0.yield_11rb$(new Unification(this.local$goalVars), this.local$closure$continuation);
              if (this.result_0 === COROUTINE_SUSPENDED)
                return COROUTINE_SUSPENDED;
              break;
            }
             else {
              this.state_0 = 10;
              this.result_0 = this.$this.fulfillAllGoals_wy1dm9$_0(this.local$$receiver_0, this.local$goals.subList_vux9f0$(1, this.local$goals.size), this.local$kb, this.local$randomVarsScope, this.local$goalVars, this.local$closure$continuation);
              if (this.result_0 === COROUTINE_SUSPENDED)
                return COROUTINE_SUSPENDED;
              break;
            }

          case 10:
            this.state_0 = 12;
            continue;
          case 11:
            this.state_0 = 12;
            continue;
          case 12:
            if (!false) {
              this.state_0 = 13;
              continue;
            }

            this.state_0 = 4;
            continue;
          case 13:
            this.state_0 = 2;
            continue;
          case 14:
            this.local$$receiver.close();
            return;
        }
      }
       catch (e) {
        if (this.state_0 === 1)
          throw e;
        else {
          this.state_0 = this.exceptionState_0;
          this.exception_0 = e;
        }
      }
     while (true);
  };
  AndQuery.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'AndQuery',
    interfaces: [Query]
  };
  function OrQuery(goals) {
    this.goals = goals;
  }
  function OrQuery$findProofWithin$lambda(this$OrQuery_0, closure$kb_0, closure$initialVariables_0, closure$randomVarsScope_0) {
    return function ($receiver_0, continuation_0, suspended) {
      var instance = new Coroutine$OrQuery$findProofWithin$lambda(this$OrQuery_0, closure$kb_0, closure$initialVariables_0, closure$randomVarsScope_0, $receiver_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function Coroutine$OrQuery$findProofWithin$lambda(this$OrQuery_0, closure$kb_0, closure$initialVariables_0, closure$randomVarsScope_0, $receiver_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$this$OrQuery = this$OrQuery_0;
    this.local$closure$kb = closure$kb_0;
    this.local$closure$initialVariables = closure$initialVariables_0;
    this.local$closure$randomVarsScope = closure$randomVarsScope_0;
    this.local$tmp$ = void 0;
    this.local$tmp$_0 = void 0;
    this.local$$receiver = $receiver_0;
  }
  Coroutine$OrQuery$findProofWithin$lambda.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$OrQuery$findProofWithin$lambda.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$OrQuery$findProofWithin$lambda.prototype.constructor = Coroutine$OrQuery$findProofWithin$lambda;
  Coroutine$OrQuery$findProofWithin$lambda.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.local$tmp$ = this.local$this$OrQuery.goals;
            this.local$tmp$_0 = 0;
            this.state_0 = 2;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            if (this.local$tmp$_0 === this.local$tmp$.length) {
              this.state_0 = 5;
              continue;
            }

            var goal = this.local$tmp$[this.local$tmp$_0];
            this.state_0 = 3;
            this.result_0 = this.local$$receiver.yieldAll_481s4d$(goal.findProofWithin_5dl3t6$(this.local$closure$kb, this.local$closure$initialVariables, this.local$closure$randomVarsScope), this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            break;
          case 3:
            this.state_0 = 4;
            continue;
          case 4:
            ++this.local$tmp$_0;
            this.state_0 = 2;
            continue;
          case 5:
            return Unit;
        }
      }
       catch (e) {
        if (this.state_0 === 1)
          throw e;
        else {
          this.state_0 = this.exceptionState_0;
          this.exception_0 = e;
        }
      }
     while (true);
  };
  OrQuery.prototype.findProofWithin_5dl3t6$$default = function (kb, initialVariables, randomVarsScope) {
    return buildLazySequence(OrQuery$findProofWithin$lambda(this, kb, initialVariables, randomVarsScope));
  };
  OrQuery.prototype.toString = function () {
    var $receiver = this.goals;
    var array = Array_0($receiver.length);
    var tmp$;
    tmp$ = array.length - 1 | 0;
    for (var i = 0; i <= tmp$; i++) {
      array[i] = $receiver[i].toString();
    }
    return joinToString_0(array, ' ; ');
  };
  OrQuery.prototype.withRandomVariables_fixsiv$ = function (randomVarsScope, mapping) {
    var $receiver = this.goals;
    var array = Array_0($receiver.length);
    var tmp$;
    tmp$ = array.length - 1 | 0;
    for (var i = 0; i <= tmp$; i++) {
      array[i] = $receiver[i].withRandomVariables_fixsiv$(randomVarsScope, mapping);
    }
    return new OrQuery(array);
  };
  OrQuery.prototype.substituteVariables_t6ifwg$ = function (variableValues) {
    var $receiver = this.goals;
    var array = Array_0($receiver.length);
    var tmp$;
    tmp$ = array.length - 1 | 0;
    for (var i = 0; i <= tmp$; i++) {
      array[i] = $receiver[i].substituteVariables_t6ifwg$(variableValues);
    }
    return new OrQuery(array);
  };
  OrQuery.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'OrQuery',
    interfaces: [Query]
  };
  function PredicateQuery(predicate) {
    this.predicate = predicate;
  }
  PredicateQuery.prototype.findProofWithin_5dl3t6$$default = function (kb, initialVariables, randomVarsScope) {
    var substitutedPredicate = this.predicate.substituteVariables_6ryr4$(initialVariables.asSubstitutionMapper());
    return kb.fulfill_idmyxu$(substitutedPredicate, randomVarsScope);
  };
  PredicateQuery.prototype.withRandomVariables_fixsiv$ = function (randomVarsScope, mapping) {
    var tmp$;
    return new PredicateQuery(Kotlin.isType(tmp$ = randomVarsScope.withRandomVariables_ggraum$(this.predicate, mapping), Predicate) ? tmp$ : throwCCE());
  };
  PredicateQuery.prototype.substituteVariables_t6ifwg$ = function (variableValues) {
    return new PredicateQuery(this.predicate.substituteVariables_6ryr4$(variableValues.asSubstitutionMapper()));
  };
  PredicateQuery.prototype.toString = function () {
    return this.predicate.toString();
  };
  PredicateQuery.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'PredicateQuery',
    interfaces: [Query]
  };
  function Query() {
  }
  Query.prototype.findProofWithin_5dl3t6$ = function (kb, initialVariables, randomVarsScope, callback$default) {
    if (initialVariables === void 0)
      initialVariables = VariableBucket_init();
    if (randomVarsScope === void 0)
      randomVarsScope = new RandomVariableScope();
    return callback$default ? callback$default(kb, initialVariables, randomVarsScope) : this.findProofWithin_5dl3t6$$default(kb, initialVariables, randomVarsScope);
  };
  Query.$metadata$ = {
    kind: Kind_INTERFACE,
    simpleName: 'Query',
    interfaces: []
  };
  function AnonymousVariable() {
    AnonymousVariable_instance = this;
    Variable.call(this, '_');
  }
  AnonymousVariable.prototype.unify_dtn93p$$default = function (rhs, randomVarsScope) {
    var randomVar = randomVarsScope.createNewRandomVariable();
    var bucket = VariableBucket_init();
    bucket.instantiate_hg6dwi$(randomVar, rhs);
    return new Unification(bucket);
  };
  AnonymousVariable.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'AnonymousVariable',
    interfaces: [Variable]
  };
  var AnonymousVariable_instance = null;
  function AnonymousVariable_getInstance() {
    if (AnonymousVariable_instance === null) {
      new AnonymousVariable();
    }
    return AnonymousVariable_instance;
  }
  function Atom(name) {
    this.name = name;
    this.variables_8lqilr$_0 = emptySet();
  }
  Atom.prototype.unify_dtn93p$$default = function (rhs, randomVarsScope) {
    if (rhs != null ? rhs.equals(this) : null) {
      return Unification$Companion_getInstance().TRUE;
    }
     else if (Kotlin.isType(rhs, Variable)) {
      return rhs.unify_dtn93p$(this);
    }
     else {
      return Unification$Companion_getInstance().FALSE;
    }
  };
  Object.defineProperty(Atom.prototype, 'variables', {
    get: function () {
      return this.variables_8lqilr$_0;
    }
  });
  Atom.prototype.substituteVariables_6ryr4$ = function (mapper) {
    return this;
  };
  Atom.prototype.toString = function () {
    var firstChar = this.name.charCodeAt(0);
    var tmp$ = !(new CharRange(48, 57)).contains_mef7kx$(firstChar);
    if (tmp$) {
      var tmp$_0 = unboxChar(String.fromCharCode(firstChar).toUpperCase().charCodeAt(0)) === firstChar;
      if (!tmp$_0) {
        var $receiver = this.name;
        tmp$_0 = Regex('\\s').containsMatchIn_6bul2c$($receiver);
      }
      tmp$ = tmp$_0;
    }
    if (tmp$) {
      return "'" + this.name + "'";
    }
     else {
      return this.name;
    }
  };
  Atom.prototype.equals = function (other) {
    if (this === other)
      return true;
    if (!Kotlin.isType(other, Atom))
      return false;
    if (!equals(this.name, other.name))
      return false;
    return true;
  };
  Atom.prototype.hashCode = function () {
    return hashCode(this.name);
  };
  Atom.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Atom',
    interfaces: [Term]
  };
  function Decimal(value) {
    this.value = value;
    this.variables_b1gv5d$_0 = emptySet();
  }
  Decimal.prototype.plus_icrx7q$ = function (other) {
    if (Kotlin.isType(other, Decimal))
      return new Decimal(this.value + other.value);
    else if (Kotlin.isType(other, Integer))
      return new Decimal(this.value + other.value.toNumber());
    else
      throw new PrologRuntimeException('Unsupported type of number');
  };
  Decimal.prototype.minus_icrx7q$ = function (other) {
    if (Kotlin.isType(other, Decimal))
      return new Decimal(this.value - other.value);
    else if (Kotlin.isType(other, Integer))
      return new Decimal(this.value - other.value.toNumber());
    else
      throw new PrologRuntimeException('Unsupported type of number');
  };
  Decimal.prototype.times_icrx7q$ = function (other) {
    if (Kotlin.isType(other, Decimal))
      return new Decimal(this.value * other.value);
    else if (Kotlin.isType(other, Integer))
      return new Decimal(this.value * other.value.toNumber());
    else
      throw new PrologRuntimeException('Unsupported type of number');
  };
  Decimal.prototype.div_icrx7q$ = function (other) {
    if (Kotlin.isType(other, Decimal))
      return new Decimal(this.value / other.value);
    else if (Kotlin.isType(other, Integer))
      return new Decimal(this.value / other.value.toNumber());
    else
      throw new PrologRuntimeException('Unsupported type of number');
  };
  Decimal.prototype.rem_icrx7q$ = function (other) {
    if (Kotlin.isType(other, Decimal))
      return new Decimal(this.value % other.value);
    else if (Kotlin.isType(other, Integer))
      return new Decimal(this.value % other.value.toNumber());
    else
      throw new PrologRuntimeException('Unsupported type of number');
  };
  var Math_0 = Math;
  Decimal.prototype.toThe_icrx7q$ = function (other) {
    var tmp$;
    if (Kotlin.isType(other, Decimal)) {
      var $receiver = this.value;
      var x = other.value;
      tmp$ = new Decimal(Math_0.pow($receiver, x));
    }
     else if (Kotlin.isType(other, Integer)) {
      var $receiver_0 = this.value;
      var x_0 = other.value.toNumber();
      tmp$ = new Decimal(Math_0.pow($receiver_0, x_0));
    }
     else
      throw new PrologRuntimeException('Unsupported type of number');
    return tmp$;
  };
  Decimal.prototype.unaryPlus = function () {
    return new Decimal(+this.value);
  };
  Decimal.prototype.unaryMinus = function () {
    return new Decimal(-this.value);
  };
  Decimal.prototype.compareTo_icrx7q$ = function (other) {
    if (Kotlin.isType(other, Integer))
      return Kotlin.primitiveCompareTo(this.value, other.value.toNumber());
    else if (Kotlin.isType(other, Decimal))
      return Kotlin.primitiveCompareTo(this.value, other.value);
    else
      throw new PrologRuntimeException('Unsupported type of number');
  };
  Decimal.prototype.unify_dtn93p$$default = function (rhs, randomVarsScope) {
    if (Kotlin.isType(rhs, Decimal)) {
      if (rhs.value === this.value) {
        return Unification$Companion_getInstance().TRUE;
      }
       else {
        return Unification$Companion_getInstance().FALSE;
      }
    }
     else if (Kotlin.isType(rhs, Integer)) {
      if (rhs.value.toNumber() === this.value) {
        return Unification$Companion_getInstance().TRUE;
      }
       else {
        return Unification$Companion_getInstance().FALSE;
      }
    }
     else {
      return rhs.unify_dtn93p$(this, randomVarsScope);
    }
  };
  Object.defineProperty(Decimal.prototype, 'variables', {
    get: function () {
      return this.variables_b1gv5d$_0;
    }
  });
  Decimal.prototype.substituteVariables_6ryr4$ = function (mapper) {
    return this;
  };
  Decimal.prototype.equals = function (other) {
    if (this === other)
      return true;
    if (!Kotlin.isType(other, Decimal))
      return false;
    if (this.value !== other.value)
      return false;
    return true;
  };
  Decimal.prototype.hashCode = function () {
    return hashCode(this.value);
  };
  Decimal.prototype.toString = function () {
    return this.value.toString();
  };
  Decimal.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Decimal',
    interfaces: [Number_0]
  };
  function Integer(value) {
    Integer$Companion_getInstance();
    this.value = value;
    this.variables_1cs5gk$_0 = emptySet();
  }
  Integer.prototype.plus_icrx7q$ = function (other) {
    if (Kotlin.isType(other, Integer))
      return Integer$Companion_getInstance().createUsingStringOptimizerCache_s8cxhz$(this.value.add(other.value));
    else if (Kotlin.isType(other, Decimal))
      return new Decimal(this.value.toNumber() + other.value);
    else
      throw new PrologRuntimeException('Unsupported type of number');
  };
  Integer.prototype.minus_icrx7q$ = function (other) {
    if (Kotlin.isType(other, Integer))
      return Integer$Companion_getInstance().createUsingStringOptimizerCache_s8cxhz$(this.value.subtract(other.value));
    else if (Kotlin.isType(other, Decimal))
      return new Decimal(this.value.toNumber() - other.value);
    else
      throw new PrologRuntimeException('Unsupported type of number');
  };
  Integer.prototype.times_icrx7q$ = function (other) {
    if (Kotlin.isType(other, Integer))
      return Integer$Companion_getInstance().createUsingStringOptimizerCache_s8cxhz$(this.value.multiply(other.value));
    else if (Kotlin.isType(other, Decimal))
      return new Decimal(this.value.toNumber() * other.value);
    else
      throw new PrologRuntimeException('Unsupported type of number');
  };
  Integer.prototype.div_icrx7q$ = function (other) {
    if (Kotlin.isType(other, Integer))
      return Integer$Companion_getInstance().createUsingStringOptimizerCache_s8cxhz$(this.value.div(other.value));
    else if (Kotlin.isType(other, Decimal))
      return new Decimal(this.value.toNumber() / other.value);
    else
      throw new PrologRuntimeException('Unsupported type of number');
  };
  Integer.prototype.rem_icrx7q$ = function (other) {
    if (Kotlin.isType(other, Integer))
      return Integer$Companion_getInstance().createUsingStringOptimizerCache_s8cxhz$(this.value.modulo(other.value));
    else if (Kotlin.isType(other, Decimal))
      return new Decimal(this.value.toNumber() % other.value);
    else
      throw new PrologRuntimeException('Unsupported type of number');
  };
  Integer.prototype.toThe_icrx7q$ = function (other) {
    var tmp$;
    if (Kotlin.isType(other, Integer)) {
      var tmp$_0 = Integer$Companion_getInstance();
      var $receiver = this.value.toNumber();
      var x = other.value.toNumber();
      tmp$ = tmp$_0.createUsingStringOptimizerCache_s8cxhz$(Kotlin.Long.fromNumber(Math_0.pow($receiver, x)));
    }
     else if (Kotlin.isType(other, Decimal)) {
      var $receiver_0 = this.value.toNumber();
      var x_0 = other.value;
      tmp$ = new Decimal(Math_0.pow($receiver_0, x_0));
    }
     else
      throw new PrologRuntimeException('Unsupported type of number');
    return tmp$;
  };
  Integer.prototype.unaryPlus = function () {
    return Integer$Companion_getInstance().createUsingStringOptimizerCache_s8cxhz$(this.value.unaryPlus());
  };
  Integer.prototype.unaryMinus = function () {
    return Integer$Companion_getInstance().createUsingStringOptimizerCache_s8cxhz$(this.value.unaryMinus());
  };
  Integer.prototype.compareTo_icrx7q$ = function (other) {
    if (Kotlin.isType(other, Integer))
      return this.value.compareTo_11rb$(other.value);
    else if (Kotlin.isType(other, Decimal))
      return Kotlin.primitiveCompareTo(this.value.toNumber(), other.value);
    else
      throw new PrologRuntimeException('Unsupported type of number');
  };
  Integer.prototype.unify_dtn93p$$default = function (rhs, randomVarsScope) {
    if (Kotlin.isType(rhs, Integer)) {
      if (equals(rhs.value, this.value)) {
        return Unification$Companion_getInstance().TRUE;
      }
       else {
        return Unification$Companion_getInstance().FALSE;
      }
    }
     else {
      return rhs.unify_dtn93p$(this, randomVarsScope);
    }
  };
  Object.defineProperty(Integer.prototype, 'variables', {
    get: function () {
      return this.variables_1cs5gk$_0;
    }
  });
  Integer.prototype.substituteVariables_6ryr4$ = function (mapper) {
    return this;
  };
  Integer.prototype.equals = function (other) {
    if (this === other)
      return true;
    if (!Kotlin.isType(other, Integer))
      return false;
    if (!equals(this.value, other.value))
      return false;
    return true;
  };
  Integer.prototype.hashCode = function () {
    return hashCode(this.value);
  };
  Integer.prototype.toString = function () {
    return this.value.toString();
  };
  function Integer$Companion() {
    Integer$Companion_instance = this;
    this.cache_0 = LinkedHashMap_init();
  }
  function Integer$Companion$createUsingStringOptimizerCache$lambda(closure$value, this$Integer$, closure$valueAsShort) {
    return function () {
      var r = new Integer(closure$value);
      var $receiver = this$Integer$.cache_0;
      var key = closure$valueAsShort;
      $receiver.put_xwzc9p$(key, r);
      return r;
    };
  }
  Integer$Companion.prototype.createUsingStringOptimizerCache_s8cxhz$ = function (value) {
    var tmp$;
    if (value.compareTo_11rb$(Kotlin.Long.fromInt(kotlin_js_internal_ShortCompanionObject.MAX_VALUE)) > 0 || value.compareTo_11rb$(Kotlin.Long.fromInt(kotlin_js_internal_ShortCompanionObject.MIN_VALUE)) < 0) {
      return new Integer(value);
    }
     else {
      var valueAsShort = toShort(value.toInt());
      return (tmp$ = this.cache_0.get_11rb$(valueAsShort)) != null ? tmp$ : Integer$Companion$createUsingStringOptimizerCache$lambda(value, this, valueAsShort)();
    }
  };
  Integer$Companion.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'Companion',
    interfaces: []
  };
  var Integer$Companion_instance = null;
  function Integer$Companion_getInstance() {
    if (Integer$Companion_instance === null) {
      new Integer$Companion();
    }
    return Integer$Companion_instance;
  }
  Integer.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Integer',
    interfaces: [Number_0]
  };
  function List_0(givenElements, givenTail) {
    if (givenTail === void 0)
      givenTail = null;
    this.elements = null;
    this.tail = null;
    var tmp$;
    if (Kotlin.isType(givenTail, List_0)) {
      this.elements = plus(givenElements, givenTail.elements);
      this.tail = givenTail.tail;
    }
     else {
      this.elements = givenElements;
      this.tail = (tmp$ = givenTail) == null || Kotlin.isType(tmp$, Variable) ? tmp$ : throwCCE();
    }
  }
  List_0.prototype.unify_dtn93p$$default = function (rhs, randomVarsScope) {
    var tmp$;
    if (Kotlin.isType(rhs, Variable)) {
      return rhs.unify_dtn93p$(this);
    }
     else if (Kotlin.isType(rhs, List_0)) {
      if (rhs.elements.size > this.elements.size) {
        return rhs.unify_dtn93p$(this, randomVarsScope);
      }
      if (this.elements.size > rhs.elements.size && rhs.tail == null) {
        return Unification$Companion_getInstance().FALSE;
      }
      var carryUnification = new Unification();
      tmp$ = get_lastIndex(this.elements);
      for (var index = 0; index <= tmp$; index++) {
        var iterationUnification;
        if (index > get_lastIndex(rhs.elements)) {
          var rhsTail = ensureNotNull(rhs.tail);
          var vars = VariableBucket_init();
          vars.instantiate_hg6dwi$(rhsTail, new List_0(this.elements.subList_vux9f0$(index, this.elements.size), this.tail));
          try {
            return carryUnification.combineWith_baofxn$(new Unification(vars));
          }
           catch (ex) {
            if (Kotlin.isType(ex, VariableDiscrepancyException)) {
              return Unification$Companion_getInstance().FALSE;
            }
             else
              throw ex;
          }
        }
         else {
          var lhsElement = this.elements.get_za3lpa$(index);
          var rhsElement = rhs.elements.get_za3lpa$(index);
          iterationUnification = lhsElement.unify_dtn93p$(rhsElement, randomVarsScope);
        }
        if (iterationUnification == null) {
          return Unification$Companion_getInstance().FALSE;
        }
         else {
          try {
            carryUnification = carryUnification.combineWith_baofxn$(iterationUnification);
          }
           catch (ex) {
            if (Kotlin.isType(ex, VariableDiscrepancyException)) {
              return Unification$Companion_getInstance().FALSE;
            }
             else
              throw ex;
          }
        }
      }
      if (this.tail != null || rhs.tail != null) {
        var tailUnification;
        if (this.tail != null && rhs.tail != null) {
          tailUnification = this.tail.unify_dtn93p$(rhs.tail, randomVarsScope);
        }
         else if (this.tail != null) {
          tailUnification = this.tail.unify_dtn93p$(new List_0(emptyList()));
        }
         else {
          tailUnification = ensureNotNull(rhs.tail).unify_dtn93p$(new List_0(emptyList()));
        }
        try {
          carryUnification = carryUnification.combineWith_baofxn$(tailUnification);
        }
         catch (ex) {
          if (Kotlin.isType(ex, VariableDiscrepancyException)) {
            return Unification$Companion_getInstance().FALSE;
          }
           else
            throw ex;
        }
      }
      return carryUnification;
    }
     else {
      return Unification$Companion_getInstance().FALSE;
    }
  };
  Object.defineProperty(List_0.prototype, 'variables', {
    get: function () {
      var $receiver = this.elements;
      var transform = getPropertyCallableRef('variables', 1, function ($receiver) {
        return $receiver.variables;
      });
      var destination = ArrayList_init();
      var tmp$;
      tmp$ = $receiver.iterator();
      while (tmp$.hasNext()) {
        var element = tmp$.next();
        var list = transform(element);
        addAll(destination, list);
      }
      var elements = toMutableSet(destination);
      if (this.tail != null) {
        elements.add_11rb$(this.tail);
      }
      return elements;
    }
  });
  var collectionSizeOrDefault = Kotlin.kotlin.collections.collectionSizeOrDefault_ba2ldo$;
  List_0.prototype.substituteVariables_6ryr4$ = function (mapper) {
    var tmp$;
    var $receiver = this.elements;
    var destination = ArrayList_init(collectionSizeOrDefault($receiver, 10));
    var tmp$_0;
    tmp$_0 = $receiver.iterator();
    while (tmp$_0.hasNext()) {
      var item = tmp$_0.next();
      destination.add_11rb$(item.substituteVariables_6ryr4$(mapper));
    }
    return new List_0(destination, (tmp$ = this.tail) != null ? tmp$.substituteVariables_6ryr4$(mapper) : null);
  };
  List_0.prototype.toString = function () {
    var out = '[' + joinToString(this.elements, ',');
    if (this.tail != null) {
      out += '|' + toString(this.tail);
    }
    return out + ']';
  };
  List_0.prototype.equals = function (other) {
    if (this === other)
      return true;
    if (!Kotlin.isType(other, List_0))
      return false;
    if (!equals(this.elements, other.elements))
      return false;
    if (!equals(this.tail, other.tail))
      return false;
    return true;
  };
  List_0.prototype.hashCode = function () {
    var tmp$, tmp$_0;
    var result = hashCode(this.elements);
    result = (31 * result | 0) + ((tmp$_0 = (tmp$ = this.tail) != null ? tmp$.hashCode() : null) != null ? tmp$_0 : 0) | 0;
    return result;
  };
  List_0.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'List',
    interfaces: [Term]
  };
  function Number_0() {
  }
  Number_0.$metadata$ = {
    kind: Kind_INTERFACE,
    simpleName: 'Number',
    interfaces: [Term]
  };
  function Predicate(name, arguments_0) {
    this.name_9hlq55$_0 = name;
    this.arguments_yps71w$_0 = arguments_0;
    this.arity_fxk2u3$_0 = arguments_0.length;
    var transform = getPropertyCallableRef('variables', 1, function ($receiver) {
      return $receiver.variables;
    });
    var destination = ArrayList_init();
    var tmp$;
    for (tmp$ = 0; tmp$ !== arguments_0.length; ++tmp$) {
      var element = arguments_0[tmp$];
      var list = transform(element);
      addAll(destination, list);
    }
    this.variables_ruw6np$_0 = toSet(destination);
  }
  Object.defineProperty(Predicate.prototype, 'name', {
    get: function () {
      return this.name_9hlq55$_0;
    }
  });
  Object.defineProperty(Predicate.prototype, 'arguments', {
    get: function () {
      return this.arguments_yps71w$_0;
    }
  });
  Object.defineProperty(Predicate.prototype, 'arity', {
    get: function () {
      return this.arity_fxk2u3$_0;
    }
  });
  Predicate.prototype.unify_dtn93p$$default = function (rhs, randomVarsScope) {
    var tmp$, tmp$_0, tmp$_1;
    if (Kotlin.isType(rhs, Predicate)) {
      if (!equals(this.name, rhs.name)) {
        return Unification$Companion_getInstance().FALSE;
      }
      if (this.arguments.length !== rhs.arguments.length) {
        return Unification$Companion_getInstance().FALSE;
      }
      if (this.arguments.length === 0) {
        return Unification$Companion_getInstance().TRUE;
      }
      var vars = VariableBucket_init();
      tmp$ = get_lastIndex_0(this.arguments);
      for (var argIndex = 0; argIndex <= tmp$; argIndex++) {
        var lhsArg = this.arguments[argIndex].substituteVariables_6ryr4$(vars.asSubstitutionMapper());
        var rhsArg = rhs.arguments[argIndex].substituteVariables_6ryr4$(vars.asSubstitutionMapper());
        var argUnification = lhsArg.unify_dtn93p$(rhsArg, randomVarsScope);
        if (argUnification == null) {
          return Unification$Companion_getInstance().FALSE;
        }
        tmp$_0 = argUnification.variableValues.values.iterator();
        while (tmp$_0.hasNext()) {
          var tmp$_2 = tmp$_0.next();
          var variable = tmp$_2.component1()
          , value = tmp$_2.component2();
          if (value != null) {
            var substitutedValue = value.substituteVariables_6ryr4$(vars.asSubstitutionMapper());
            if (vars.isInstantiated_cua0ab$(variable)) {
              if (!((tmp$_1 = vars.get_cua0ab$(variable)) != null ? tmp$_1.equals(substitutedValue) : null) && !equals(vars.get_cua0ab$(variable), value)) {
                return Unification$Companion_getInstance().FALSE;
              }
            }
             else {
              vars.instantiate_hg6dwi$(variable, substitutedValue);
            }
          }
        }
      }
      return new Unification(vars);
    }
     else if (Kotlin.isType(rhs, Variable)) {
      return rhs.unify_dtn93p$(this);
    }
     else {
      return Unification$Companion_getInstance().FALSE;
    }
  };
  Predicate.prototype.unifyWithKnowledge_okb83k$ = function (other, kb, randomVariableScope) {
    var unification = this.unify_dtn93p$(other, randomVariableScope);
    return unification == null ? Unification$Companion_getInstance().NONE : LazySequence$Companion_getInstance().of_i5x0yv$([unification]);
  };
  Object.defineProperty(Predicate.prototype, 'variables', {
    get: function () {
      return this.variables_ruw6np$_0;
    }
  });
  var copyToArray = Kotlin.kotlin.collections.copyToArray;
  Predicate.prototype.substituteVariables_6ryr4$ = function (mapper) {
    var tmp$ = this.name;
    var $receiver = this.arguments;
    var destination = ArrayList_init($receiver.length);
    var tmp$_0;
    for (tmp$_0 = 0; tmp$_0 !== $receiver.length; ++tmp$_0) {
      var item = $receiver[tmp$_0];
      destination.add_11rb$(item.substituteVariables_6ryr4$(mapper));
    }
    return new Predicate(tmp$, copyToArray(destination));
  };
  Predicate.prototype.toString = function () {
    return this.name + '(' + joinToString_0(this.arguments, ', ') + ')';
  };
  Predicate.prototype.equals = function (other) {
    if (this === other)
      return true;
    if (!Kotlin.isType(other, Predicate))
      return false;
    if (!equals(this.name, other.name))
      return false;
    if (contentDeepEquals(this.arguments, other.arguments))
      return true;
    return false;
  };
  Predicate.prototype.hashCode = function () {
    var result = hashCode(this.name);
    result = (31 * result | 0) + sensibleHashCode(this.arguments) | 0;
    return result;
  };
  Predicate.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Predicate',
    interfaces: [LibraryEntry, Term]
  };
  function PredicateBuilder(predicateName) {
    this.predicateName_0 = predicateName;
  }
  PredicateBuilder.prototype.invoke_my9vlm$ = function (arguments_0) {
    return new Predicate(this.predicateName_0, arguments_0);
  };
  PredicateBuilder.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'PredicateBuilder',
    interfaces: []
  };
  function PrologString(data) {
    List_0.call(this, data);
    this.data_apn36t$_0 = data;
    var $receiver = this.data_apn36t$_0;
    var any$result;
    any$break: do {
      var tmp$;
      if (Kotlin.isType($receiver, Collection) && $receiver.isEmpty()) {
        any$result = false;
        break any$break;
      }
      tmp$ = $receiver.iterator();
      while (tmp$.hasNext()) {
        var element = tmp$.next();
        if (element.value.compareTo_11rb$(Kotlin.Long.fromInt(0)) < 0 || element.value.compareTo_11rb$(Kotlin.Long.fromInt(65535)) > 0) {
          any$result = true;
          break any$break;
        }
      }
      any$result = false;
    }
     while (false);
    if (any$result)
      throw new IllegalArgumentException('Prolog strings must only contain unicode values in the range [0; 65535]');
    this.length = this.data_apn36t$_0.size;
    this.characters_rg8ufv$_0 = lazy(PrologString$characters$lambda(this));
    this.variables_khoe9k$_0 = emptySet();
    this.kotlinString_grlzu5$_0 = null;
  }
  PrologString.prototype.charAt_za3lpa$ = function (index) {
    return toBoxedChar(toChar(this.data_apn36t$_0.get_za3lpa$(index).value.toInt()));
  };
  PrologString.prototype.substring_za3lpa$ = function (beginIndex) {
    if (beginIndex >= this.length)
      throw new IndexOutOfBoundsException();
    return new PrologString(this.data_apn36t$_0.subList_vux9f0$(beginIndex, this.length - 1 | 0));
  };
  PrologString.prototype.substring_vux9f0$ = function (fromIndex, toIndex) {
    return new PrologString(this.data_apn36t$_0.subList_vux9f0$(fromIndex, toIndex));
  };
  Object.defineProperty(PrologString.prototype, 'characters', {
    get: function () {
      var $receiver = this.characters_rg8ufv$_0;
      new PropertyMetadata('characters');
      return $receiver.value;
    }
  });
  Object.defineProperty(PrologString.prototype, 'variables', {
    get: function () {
      return this.variables_khoe9k$_0;
    }
  });
  PrologString.prototype.substituteVariables_6ryr4$ = function (mapper) {
    return this;
  };
  PrologString.prototype.equals = function (other) {
    var tmp$;
    if (Kotlin.isType(other, PrologString)) {
      return (tmp$ = this.data_apn36t$_0) != null ? tmp$.equals(other.data_apn36t$_0) : null;
    }
     else
      return List_0.prototype.equals.call(this, other);
  };
  PrologString.prototype.hashCode = function () {
    return List_0.prototype.hashCode.call(this);
  };
  function PrologString$toKotlinString$lambda(this$PrologString) {
    return function () {
      var str = joinToString(this$PrologString.characters);
      this$PrologString.kotlinString_grlzu5$_0 = str;
      return str;
    };
  }
  PrologString.prototype.toKotlinString = function () {
    var tmp$;
    return (tmp$ = this.kotlinString_grlzu5$_0) != null ? tmp$ : PrologString$toKotlinString$lambda(this)();
  };
  PrologString.prototype.toString = function () {
    var other = replace(replace(replace(replace(replace(replace(replace(replace(replace(this.toKotlinString(), '\\', '\\\\'), '\x07', '\\a'), '\b', '\\b'), "'", '\\e'), '\n', '\\n'), '\r', '\\r'), '\t', '\\t'), '\x11', '\\v'), '"', '\\');
    return String.fromCharCode(34) + other + String.fromCharCode(toBoxedChar(34));
  };
  function PrologString$characters$lambda(this$PrologString) {
    return function () {
      return new PrologStringCharacterIterable(this$PrologString);
    };
  }
  PrologString.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'PrologString',
    interfaces: [List_0]
  };
  function PrologString_init(chars, beginIndex, length, $this) {
    if (beginIndex === void 0)
      beginIndex = 0;
    if (length === void 0)
      length = chars.length;
    $this = $this || Object.create(PrologString.prototype);
    var $receiver = toList_0(chars);
    var destination = ArrayList_init(collectionSizeOrDefault($receiver, 10));
    var tmp$;
    tmp$ = $receiver.iterator();
    while (tmp$.hasNext()) {
      var item = tmp$.next();
      destination.add_11rb$(new Integer(Kotlin.Long.fromInt(unboxChar(item) | 0)));
    }
    PrologString.call($this, new ImmutableSubList(destination, beginIndex, length));
    return $this;
  }
  function PrologString_init_0(str, $this) {
    $this = $this || Object.create(PrologString.prototype);
    PrologString_init(PrologString_init$lambda(str)(), void 0, void 0, $this);
    return $this;
  }
  function PrologString_init$lambda(closure$str) {
    return function () {
      var tmp$;
      var ar = Kotlin.charArray(closure$str.length);
      tmp$ = get_lastIndex_1(closure$str);
      for (var i = 0; i <= tmp$; i++) {
        ar[i] = closure$str.charCodeAt(i);
      }
      return ar;
    };
  }
  function PrologStringCharacterIterable(str) {
    this.str = str;
  }
  function PrologStringCharacterIterable$iterator$ObjectLiteral(this$PrologStringCharacterIterable) {
    this.this$PrologStringCharacterIterable = this$PrologStringCharacterIterable;
    this.currentIndex_0 = 0;
  }
  PrologStringCharacterIterable$iterator$ObjectLiteral.prototype.hasNext = function () {
    return this.this$PrologStringCharacterIterable.str.length > this.currentIndex_0;
  };
  PrologStringCharacterIterable$iterator$ObjectLiteral.prototype.next = function () {
    var tmp$;
    return this.this$PrologStringCharacterIterable.str.charAt_za3lpa$((tmp$ = this.currentIndex_0, this.currentIndex_0 = tmp$ + 1 | 0, tmp$));
  };
  PrologStringCharacterIterable$iterator$ObjectLiteral.$metadata$ = {
    kind: Kind_CLASS,
    interfaces: [Iterator]
  };
  PrologStringCharacterIterable.prototype.iterator = function () {
    return new PrologStringCharacterIterable$iterator$ObjectLiteral(this);
  };
  PrologStringCharacterIterable.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'PrologStringCharacterIterable',
    interfaces: [Iterable]
  };
  function Term() {
  }
  Term.prototype.unify_dtn93p$ = function (rhs, randomVarsScope, callback$default) {
    if (randomVarsScope === void 0)
      randomVarsScope = new RandomVariableScope();
    return callback$default ? callback$default(rhs, randomVarsScope) : this.unify_dtn93p$$default(rhs, randomVarsScope);
  };
  Term.$metadata$ = {
    kind: Kind_INTERFACE,
    simpleName: 'Term',
    interfaces: []
  };
  function Variable(name) {
    Variable$Companion_getInstance();
    this.name = name;
  }
  Variable.prototype.unify_dtn93p$$default = function (rhs, randomVarsScope) {
    if (Kotlin.isType(rhs, Variable) && (rhs != null ? rhs.equals(this) : null))
      return Unification$Companion_getInstance().TRUE;
    var vars = VariableBucket_init();
    vars.instantiate_hg6dwi$(this, rhs);
    return new Unification(vars);
  };
  Object.defineProperty(Variable.prototype, 'variables', {
    get: function () {
      return setOf(this);
    }
  });
  Variable.prototype.substituteVariables_6ryr4$ = function (mapper) {
    return mapper(this);
  };
  Variable.prototype.toString = function () {
    return this.name;
  };
  Variable.prototype.equals = function (other) {
    if (this === other)
      return true;
    if (!Kotlin.isType(other, Variable))
      return false;
    if (!equals(this.name, other.name))
      return false;
    return true;
  };
  Variable.prototype.hashCode = function () {
    return hashCode(this.name);
  };
  function Variable$Companion() {
    Variable$Companion_instance = this;
    this.ANONYMOUS = AnonymousVariable_getInstance();
  }
  Variable$Companion.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'Companion',
    interfaces: []
  };
  var Variable$Companion_instance = null;
  function Variable$Companion_getInstance() {
    if (Variable$Companion_instance === null) {
      new Variable$Companion();
    }
    return Variable$Companion_instance;
  }
  Variable.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Variable',
    interfaces: [Term]
  };
  function Unification(variableValues) {
    Unification$Companion_getInstance();
    if (variableValues === void 0)
      variableValues = VariableBucket_init();
    this.variableValues = variableValues;
  }
  Unification.prototype.combineWith_baofxn$ = function (other) {
    return new Unification(this.variableValues.combineWith_t6ifwg$(other.variableValues));
  };
  Unification.prototype.toString = function () {
    var $receiver = this.variableValues.values;
    var destination = ArrayList_init(collectionSizeOrDefault($receiver, 10));
    var tmp$;
    tmp$ = $receiver.iterator();
    while (tmp$.hasNext()) {
      var item = tmp$.next();
      var tmp$_0 = destination.add_11rb$;
      var variable = item.component1()
      , value = item.component2();
      tmp$_0.call(destination, variable.toString() + ' = ' + (value != null ? value : Variable$Companion_getInstance().ANONYMOUS));
    }
    return joinToString(destination, ', ');
  };
  Unification.prototype.equals = function (other) {
    var tmp$, tmp$_0;
    if (this === other)
      return true;
    Kotlin.isType(tmp$ = other, Unification) ? tmp$ : throwCCE();
    if (!((tmp$_0 = this.variableValues) != null ? tmp$_0.equals(other.variableValues) : null))
      return false;
    return true;
  };
  Unification.prototype.hashCode = function () {
    return this.variableValues.hashCode();
  };
  function Unification$Companion() {
    Unification$Companion_instance = this;
    this.FALSE = null;
    this.TRUE = new Unification();
    this.SINGLETON = LazySequence$Companion_getInstance().of_i5x0yv$([this.TRUE]);
    this.NONE = LazySequence$Companion_getInstance().empty_287e2$();
  }
  Unification$Companion.prototype.whether_6taknv$ = function (condition) {
    return condition ? this.TRUE : this.FALSE;
  };
  Unification$Companion.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'Companion',
    interfaces: []
  };
  var Unification$Companion_instance = null;
  function Unification$Companion_getInstance() {
    if (Unification$Companion_instance === null) {
      new Unification$Companion();
    }
    return Unification$Companion_instance;
  }
  Unification.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Unification',
    interfaces: []
  };
  function UnificationException(message, cause) {
    if (cause === void 0)
      cause = null;
    RuntimeException.call(this, message);
    this.cause_8hnj97$_0 = cause;
    this.name = 'UnificationException';
  }
  Object.defineProperty(UnificationException.prototype, 'cause', {
    get: function () {
      return this.cause_8hnj97$_0;
    }
  });
  UnificationException.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'UnificationException',
    interfaces: [RuntimeException]
  };
  function VariableBucket(variableMap) {
    this.variableMap_0 = variableMap;
    this.substitutionMapper_0 = VariableBucket$substitutionMapper$lambda(this);
  }
  Object.defineProperty(VariableBucket.prototype, 'isEmpty', {
    get: function () {
      return this.variableMap_0.isEmpty();
    }
  });
  VariableBucket.prototype.asSubstitutionMapper = function () {
    return this.substitutionMapper_0;
  };
  VariableBucket.prototype.get_cua0ab$ = function (v) {
    if (this.isInstantiated_cua0ab$(v)) {
      return ensureNotNull(this.variableMap_0.get_11rb$(v));
    }
     else {
      throw new NameError('Variable ' + v + ' has not been instantiated yet.');
    }
  };
  VariableBucket.prototype.instantiate_hg6dwi$ = function (variable, value) {
    if (this.isInstantiated_cua0ab$(variable)) {
      throw new NameError('Variable ' + variable + ' is already instantiated in this bucket.');
    }
    this.variableMap_0.put_xwzc9p$(variable, value);
  };
  VariableBucket.prototype.isInstantiated_cua0ab$ = function (variable) {
    return this.variableMap_0.get_11rb$(variable) != null;
  };
  VariableBucket.prototype.combineWith_t6ifwg$ = function (other) {
    var tmp$;
    var copy = this.copy();
    tmp$ = other.variableMap_0.entries.iterator();
    while (tmp$.hasNext()) {
      var tmp$_0 = tmp$.next();
      var variableName = tmp$_0.key;
      var othersValue = tmp$_0.value;
      var $receiver = copy.variableMap_0;
      var tmp$_1;
      if (!(Kotlin.isType(tmp$_1 = $receiver, Map) ? tmp$_1 : throwCCE()).containsKey_11rb$(variableName)) {
        copy.variableMap_0.put_xwzc9p$(variableName, othersValue);
      }
       else {
        var thisValue = copy.variableMap_0.get_11rb$(variableName);
        if (thisValue != null && othersValue != null) {
          if (!equals(thisValue, othersValue)) {
            throw new VariableDiscrepancyException('Cannot combine: variable ' + variableName + ' is instantiated to unequal values: ' + toString(thisValue) + ' and ' + toString(othersValue));
          }
        }
         else if (othersValue != null) {
          copy.variableMap_0.put_xwzc9p$(variableName, othersValue);
        }
      }
    }
    return copy;
  };
  VariableBucket.prototype.copy = function () {
    var mapCopy = LinkedHashMap_init();
    mapCopy.putAll_a2k3zr$(this.variableMap_0);
    return new VariableBucket(mapCopy);
  };
  function VariableBucket$retainAll$lambda(closure$removedToSubstitute) {
    return function (variable) {
      var tmp$;
      return (tmp$ = closure$removedToSubstitute.get_11rb$(variable)) != null ? tmp$ : variable;
    };
  }
  VariableBucket.prototype.retainAll_uifa2s$ = function (variables) {
    var tmp$, tmp$_0;
    var $receiver = this.variableMap_0.keys;
    var destination = ArrayList_init();
    var tmp$_1;
    tmp$_1 = $receiver.iterator();
    while (tmp$_1.hasNext()) {
      var element = tmp$_1.next();
      if (!variables.contains_11rb$(element))
        destination.add_11rb$(element);
    }
    var keysToRemove = destination;
    var removedToSubstitute = LinkedHashMap_init();
    tmp$ = keysToRemove.iterator();
    while (tmp$.hasNext()) {
      var key = tmp$.next();
      var value = this.variableMap_0.get_11rb$(key);
      if (value != null) {
        removedToSubstitute.put_xwzc9p$(key, value);
      }
      this.variableMap_0.remove_11rb$(key);
    }
    tmp$_0 = this.variableMap_0.entries.iterator();
    while (tmp$_0.hasNext()) {
      var tmp$_2 = tmp$_0.next();
      var key_0 = tmp$_2.key;
      var value_0 = tmp$_2.value;
      if (value_0 != null) {
        var $receiver_0 = this.variableMap_0;
        var value_1 = value_0.substituteVariables_6ryr4$(VariableBucket$retainAll$lambda(removedToSubstitute));
        $receiver_0.put_xwzc9p$(key_0, value_1);
      }
    }
  };
  function VariableBucket$withVariablesResolvedFrom$resolve(closure$mapping) {
    return function (variable) {
      var pivot = variable;
      while (closure$mapping.hasSubstitution_cua0ab$(pivot)) {
        pivot = ensureNotNull(closure$mapping.getOriginal_cua0ab$(pivot));
      }
      return pivot;
    };
  }
  VariableBucket.prototype.withVariablesResolvedFrom_ydv0fz$ = function (mapping) {
    var tmp$;
    var resolve = VariableBucket$withVariablesResolvedFrom$resolve(mapping);
    var newBucket = VariableBucket_init();
    tmp$ = this.values.iterator();
    while (tmp$.hasNext()) {
      var tmp$_0 = tmp$.next();
      var variable = tmp$_0.component1()
      , value = tmp$_0.component2();
      var resolved = resolve(variable);
      if (value != null) {
        var resolvedValue = value.substituteVariables_6ryr4$(getCallableRef('resolve', function (variable) {
          return resolve(variable);
        }));
        newBucket.instantiate_hg6dwi$(resolved, resolvedValue);
      }
    }
    return newBucket;
  };
  VariableBucket.prototype.equals = function (other) {
    var tmp$;
    if (this === other)
      return true;
    Kotlin.isType(tmp$ = other, VariableBucket) ? tmp$ : throwCCE();
    if (!equals(this.variableMap_0, other.variableMap_0))
      return false;
    return true;
  };
  VariableBucket.prototype.hashCode = function () {
    return hashCode(this.variableMap_0);
  };
  Object.defineProperty(VariableBucket.prototype, 'values', {
    get: function () {
      var $receiver = this.variableMap_0;
      var destination = ArrayList_init($receiver.size);
      var tmp$;
      tmp$ = $receiver.entries.iterator();
      while (tmp$.hasNext()) {
        var item = tmp$.next();
        destination.add_11rb$(to(item.key, item.value));
      }
      return destination;
    }
  });
  function VariableBucket$substitutionMapper$lambda(this$VariableBucket) {
    return function (variable) {
      var tmp$;
      if (this$VariableBucket.isInstantiated_cua0ab$(variable) && !((tmp$ = this$VariableBucket.get_cua0ab$(variable)) != null ? tmp$.equals(variable) : null)) {
        return this$VariableBucket.get_cua0ab$(variable).substituteVariables_6ryr4$(this$VariableBucket.asSubstitutionMapper());
      }
       else {
        return variable;
      }
    };
  }
  VariableBucket.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'VariableBucket',
    interfaces: []
  };
  function VariableBucket_init($this) {
    $this = $this || Object.create(VariableBucket.prototype);
    VariableBucket.call($this, LinkedHashMap_init());
    return $this;
  }
  function NameError(message, cause) {
    if (cause === void 0)
      cause = null;
    RuntimeException.call(this, message);
    this.cause_e5zbr8$_0 = cause;
    this.name = 'NameError';
  }
  Object.defineProperty(NameError.prototype, 'cause', {
    get: function () {
      return this.cause_e5zbr8$_0;
    }
  });
  NameError.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'NameError',
    interfaces: [RuntimeException]
  };
  function VariableDiscrepancyException(message, cause) {
    if (cause === void 0)
      cause = null;
    UnificationException.call(this, message, cause);
    this.name = 'VariableDiscrepancyException';
  }
  VariableDiscrepancyException.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'VariableDiscrepancyException',
    interfaces: [UnificationException]
  };
  function sensibleHashCode($receiver) {
    var tmp$;
    if ($receiver == null)
      return 0;
    var result = 1;
    for (tmp$ = 0; tmp$ !== $receiver.length; ++tmp$) {
      var element = $receiver[tmp$];
      result = (31 * result | 0) + (element == null ? 0 : hashCode(element)) | 0;
    }
    return result;
  }
  var mapToArray = defineInlineFunction('runtime-core-js.mapToArray_ucvlcw$', wrapFunction(function () {
    var Array_0 = Array;
    return function (R_0, isR, $receiver, mapper) {
      var array = Array_0($receiver.length);
      var tmp$;
      tmp$ = array.length - 1 | 0;
      for (var i = 0; i <= tmp$; i++) {
        array[i] = mapper($receiver[i]);
      }
      return array;
    };
  }));
  var package$com = _.com || (_.com = {});
  var package$github = package$com.github || (package$com.github = {});
  var package$prologdb = package$github.prologdb || (package$github.prologdb = {});
  var package$runtime = package$prologdb.runtime || (package$prologdb.runtime = {});
  package$runtime.ArityMap = ArityMap;
  package$runtime.ImmutableSubList = ImmutableSubList;
  package$runtime.RandomVariable = RandomVariable;
  package$runtime.RandomVariableScope = RandomVariableScope;
  package$runtime.VariableMapping = VariableMapping;
  var package$builtin = package$runtime.builtin || (package$runtime.builtin = {});
  Object.defineProperty(package$builtin, 'surrogateVarLHS_8be2vx$', {
    get: function () {
      return surrogateVarLHS;
    }
  });
  Object.defineProperty(package$builtin, 'surrogateVarRHS_8be2vx$', {
    get: function () {
      return surrogateVarRHS;
    }
  });
  Object.defineProperty(package$builtin, 'A_8be2vx$', {
    get: function () {
      return A;
    }
  });
  Object.defineProperty(package$builtin, 'B_8be2vx$', {
    get: function () {
      return B;
    }
  });
  Object.defineProperty(package$builtin, 'X_8be2vx$', {
    get: function () {
      return X;
    }
  });
  package$builtin.BuiltinPredicate = BuiltinPredicate;
  Object.defineProperty(package$builtin, 'EqualityLibrary', {
    get: function () {
      return EqualityLibrary;
    }
  });
  Object.defineProperty(package$builtin, 'NegationRule', {
    get: NegationRule_getInstance
  });
  Object.defineProperty(package$builtin, 'IdentityPredicate', {
    get: IdentityPredicate_getInstance
  });
  Object.defineProperty(package$builtin, 'MathLibrary', {
    get: function () {
      return MathLibrary;
    }
  });
  Object.defineProperty(package$builtin, 'MathOperatorRegistry', {
    get: MathOperatorRegistry_getInstance
  });
  Object.defineProperty(package$builtin, 'IsRule', {
    get: IsRule_getInstance
  });
  package$builtin.get_asNumber_ppnqum$ = get_asNumber;
  Object.defineProperty(package$builtin, 'GreaterThanPredicate', {
    get: GreaterThanPredicate_getInstance
  });
  Object.defineProperty(package$builtin, 'LessThanOrEqualPredicate', {
    get: LessThanOrEqualPredicate_getInstance
  });
  Object.defineProperty(package$builtin, 'TypeSafetyLibrary', {
    get: function () {
      return TypeSafetyLibrary;
    }
  });
  Object.defineProperty(package$builtin, 'IsAtomPredicate', {
    get: IsAtomPredicate_getInstance
  });
  package$runtime.PrologException = PrologException;
  package$runtime.PrologRuntimeException = PrologRuntimeException;
  package$runtime.IllegalDirectiveException_init_76kv2e$ = IllegalDirectiveException_init;
  package$runtime.IllegalDirectiveException = IllegalDirectiveException;
  var package$knowledge = package$runtime.knowledge || (package$runtime.knowledge = {});
  package$knowledge.DefaultKnowledgeBase = DefaultKnowledgeBase;
  package$knowledge.Rule = Rule;
  Object.defineProperty(KnowledgeBase, 'Companion', {
    get: KnowledgeBase$Companion_getInstance
  });
  package$knowledge.KnowledgeBase = KnowledgeBase;
  package$knowledge.MutableKnowledgeBase = MutableKnowledgeBase;
  package$knowledge.EmptyKnowledgeBase = EmptyKnowledgeBase;
  var package$library = package$knowledge.library || (package$knowledge.library = {});
  package$library.DefaultOperatorRegistry_init = DefaultOperatorRegistry_init;
  package$library.DefaultOperatorRegistry = DefaultOperatorRegistry;
  package$library.DoublyIndexedLibraryEntryStore = DoublyIndexedLibraryEntryStore;
  Object.defineProperty(package$library, 'EmptyOperatorRegistry', {
    get: EmptyOperatorRegistry_getInstance
  });
  package$library.SimpleLibrary = SimpleLibrary;
  package$library.SimpleLibraryEntryStore = SimpleLibraryEntryStore;
  package$library.PredicatePrototype = PredicatePrototype;
  package$library.LibraryEntry = LibraryEntry;
  package$library.LibraryEntryStore = LibraryEntryStore;
  package$library.MutableLibraryEntryStore = MutableLibraryEntryStore;
  package$library.OperatorRegistry = OperatorRegistry;
  package$library.MutableOperatorRegistry = MutableOperatorRegistry;
  package$library.OperatorDefinition = OperatorDefinition;
  Object.defineProperty(OperatorType, 'FX', {
    get: OperatorType$FX_getInstance
  });
  Object.defineProperty(OperatorType, 'FY', {
    get: OperatorType$FY_getInstance
  });
  Object.defineProperty(OperatorType, 'XFX', {
    get: OperatorType$XFX_getInstance
  });
  Object.defineProperty(OperatorType, 'XFY', {
    get: OperatorType$XFY_getInstance
  });
  Object.defineProperty(OperatorType, 'YFX', {
    get: OperatorType$YFX_getInstance
  });
  Object.defineProperty(OperatorType, 'XF', {
    get: OperatorType$XF_getInstance
  });
  Object.defineProperty(OperatorType, 'YF', {
    get: OperatorType$YF_getInstance
  });
  package$library.OperatorType = OperatorType;
  package$library.Library = Library;
  package$library.MutableLibrary = MutableLibrary;
  var package$lazysequence = package$runtime.lazysequence || (package$runtime.lazysequence = {});
  package$lazysequence.DistinctLazySequence = DistinctLazySequence;
  package$lazysequence.FilteredLazySequence = FilteredLazySequence;
  $$importsForInline$$['runtime-core-js'] = _;
  Object.defineProperty(LazySequence, 'Companion', {
    get: LazySequence$Companion_getInstance
  });
  package$lazysequence.LazySequence = LazySequence;
  package$lazysequence.remainingTo_6uva0j$ = remainingTo;
  package$lazysequence.find_qz139f$ = find;
  package$lazysequence.filterRemainingNotNull_jacdoe$ = filterRemainingNotNull;
  package$lazysequence.filterRemaining_qz139f$ = filterRemaining;
  package$lazysequence.mapRemaining_d3ezg4$ = mapRemaining;
  package$lazysequence.forEachRemaining_pg9z47$ = forEachRemaining;
  package$lazysequence.LazySequenceBuilder = LazySequenceBuilder;
  package$lazysequence.buildLazySequence_pv639t$ = buildLazySequence;
  package$lazysequence.MappedLazySequence = MappedLazySequence;
  var package$query = package$runtime.query || (package$runtime.query = {});
  package$query.AndQuery = AndQuery;
  package$query.OrQuery = OrQuery;
  package$query.PredicateQuery = PredicateQuery;
  package$query.Query = Query;
  var package$term = package$runtime.term || (package$runtime.term = {});
  Object.defineProperty(package$term, 'AnonymousVariable', {
    get: AnonymousVariable_getInstance
  });
  package$term.Atom = Atom;
  package$term.Decimal = Decimal;
  Object.defineProperty(Integer, 'Companion', {
    get: Integer$Companion_getInstance
  });
  package$term.Integer = Integer;
  package$term.List = List_0;
  package$term.Number = Number_0;
  package$term.Predicate = Predicate;
  package$term.PredicateBuilder = PredicateBuilder;
  package$term.PrologString_init_8chfmy$ = PrologString_init;
  package$term.PrologString_init_61zpoe$ = PrologString_init_0;
  package$term.PrologString = PrologString;
  package$term.Term = Term;
  Object.defineProperty(Variable, 'Companion', {
    get: Variable$Companion_getInstance
  });
  package$term.Variable = Variable;
  Object.defineProperty(Unification, 'Companion', {
    get: Unification$Companion_getInstance
  });
  var package$unification = package$runtime.unification || (package$runtime.unification = {});
  package$unification.Unification = Unification;
  package$unification.UnificationException = UnificationException;
  package$unification.VariableBucket_init = VariableBucket_init;
  package$unification.VariableBucket = VariableBucket;
  package$unification.NameError = NameError;
  package$unification.VariableDiscrepancyException = VariableDiscrepancyException;
  _.sensibleHashCode_o3r8p$ = sensibleHashCode;
  Variable.prototype.unify_dtn93p$ = Term.prototype.unify_dtn93p$;
  LibraryEntry.prototype.asIdiomatic = PredicatePrototype.prototype.asIdiomatic;
  Predicate.prototype.asIdiomatic = PredicatePrototype.prototype.asIdiomatic;
  Predicate.prototype.unify_dtn93p$ = Term.prototype.unify_dtn93p$;
  Library.prototype.findFor_76kv2e$ = LibraryEntryStore.prototype.findFor_76kv2e$;
  MutableLibraryEntryStore.prototype.findFor_76kv2e$ = LibraryEntryStore.prototype.findFor_76kv2e$;
  MutableLibrary.prototype.include_w13h4a$ = MutableLibraryEntryStore.prototype.include_w13h4a$;
  MutableLibrary.prototype.include_8ngtbf$ = MutableOperatorRegistry.prototype.include_8ngtbf$;
  MutableLibrary.prototype.retractAllFacts_76kv2e$ = MutableLibraryEntryStore.prototype.retractAllFacts_76kv2e$;
  MutableLibrary.prototype.retractAll_76kv2e$ = MutableLibraryEntryStore.prototype.retractAll_76kv2e$;
  MutableLibrary.prototype.abolishFacts_bm4lxs$ = MutableLibraryEntryStore.prototype.abolishFacts_bm4lxs$;
  MutableLibrary.prototype.abolish_bm4lxs$ = MutableLibraryEntryStore.prototype.abolish_bm4lxs$;
  SimpleLibrary.prototype.include_5bfbyx$ = MutableLibrary.prototype.include_5bfbyx$;
  SimpleLibrary.prototype.include_w13h4a$ = MutableLibraryEntryStore.prototype.include_w13h4a$;
  SimpleLibrary.prototype.include_8ngtbf$ = MutableOperatorRegistry.prototype.include_8ngtbf$;
  SimpleLibrary.prototype.retractAllFacts_76kv2e$ = MutableLibraryEntryStore.prototype.retractAllFacts_76kv2e$;
  SimpleLibrary.prototype.retractAll_76kv2e$ = MutableLibraryEntryStore.prototype.retractAll_76kv2e$;
  SimpleLibrary.prototype.abolishFacts_bm4lxs$ = MutableLibraryEntryStore.prototype.abolishFacts_bm4lxs$;
  SimpleLibrary.prototype.abolish_bm4lxs$ = MutableLibraryEntryStore.prototype.abolish_bm4lxs$;
  Rule.prototype.asIdiomatic = PredicatePrototype.prototype.asIdiomatic;
  MutableKnowledgeBase.prototype.fulfill_idmyxu$ = KnowledgeBase.prototype.fulfill_idmyxu$;
  MutableKnowledgeBase.prototype.fulfill_z9vbnb$ = KnowledgeBase.prototype.fulfill_z9vbnb$;
  MutableKnowledgeBase.prototype.fulfill_z9vbnb$$default = KnowledgeBase.prototype.fulfill_z9vbnb$$default;
  DefaultKnowledgeBase.prototype.fulfill_z9vbnb$ = KnowledgeBase.prototype.fulfill_z9vbnb$;
  DefaultKnowledgeBase.prototype.fulfill_z9vbnb$$default = KnowledgeBase.prototype.fulfill_z9vbnb$$default;
  DefaultKnowledgeBase.prototype.fulfill_idmyxu$ = KnowledgeBase.prototype.fulfill_idmyxu$;
  EmptyKnowledgeBase.prototype.fulfill_z9vbnb$ = KnowledgeBase.prototype.fulfill_z9vbnb$;
  EmptyKnowledgeBase.prototype.fulfill_z9vbnb$$default = KnowledgeBase.prototype.fulfill_z9vbnb$$default;
  EmptyKnowledgeBase.prototype.fulfill_idmyxu$ = KnowledgeBase.prototype.fulfill_idmyxu$;
  DoublyIndexedLibraryEntryStore.prototype.retractAllFacts_76kv2e$ = MutableLibraryEntryStore.prototype.retractAllFacts_76kv2e$;
  DoublyIndexedLibraryEntryStore.prototype.retractAll_76kv2e$ = MutableLibraryEntryStore.prototype.retractAll_76kv2e$;
  SimpleLibraryEntryStore.prototype.include_w13h4a$ = MutableLibraryEntryStore.prototype.include_w13h4a$;
  SimpleLibraryEntryStore.prototype.retractAllFacts_76kv2e$ = MutableLibraryEntryStore.prototype.retractAllFacts_76kv2e$;
  SimpleLibraryEntryStore.prototype.retractAll_76kv2e$ = MutableLibraryEntryStore.prototype.retractAll_76kv2e$;
  SimpleLibraryEntryStore.prototype.findFor_76kv2e$ = LibraryEntryStore.prototype.findFor_76kv2e$;
  DistinctLazySequence.prototype.skip_za3lpa$ = LazySequence.prototype.skip_za3lpa$;
  DistinctLazySequence.prototype.minBy_mt9pj$ = LazySequence.prototype.minBy_mt9pj$;
  DistinctLazySequence.prototype.distinctBy_2o04qz$ = LazySequence.prototype.distinctBy_2o04qz$;
  DistinctLazySequence.prototype.minWith_h0x69c$ = LazySequence.prototype.minWith_h0x69c$;
  DistinctLazySequence.prototype.maxWith_h0x69c$ = LazySequence.prototype.maxWith_h0x69c$;
  DistinctLazySequence.prototype.consumeAll = LazySequence.prototype.consumeAll;
  DistinctLazySequence.prototype.maxByWith_ignqx2$ = LazySequence.prototype.maxByWith_ignqx2$;
  DistinctLazySequence.prototype.distinct = LazySequence.prototype.distinct;
  DistinctLazySequence.prototype.maxBy_mt9pj$ = LazySequence.prototype.maxBy_mt9pj$;
  DistinctLazySequence.prototype.minByWith_ignqx2$ = LazySequence.prototype.minByWith_ignqx2$;
  DistinctLazySequence.prototype.foldRemaining_b8xf17$ = LazySequence.prototype.foldRemaining_b8xf17$;
  FilteredLazySequence.prototype.maxByWith_ignqx2$ = LazySequence.prototype.maxByWith_ignqx2$;
  FilteredLazySequence.prototype.distinctBy_2o04qz$ = LazySequence.prototype.distinctBy_2o04qz$;
  FilteredLazySequence.prototype.maxBy_mt9pj$ = LazySequence.prototype.maxBy_mt9pj$;
  FilteredLazySequence.prototype.skip_za3lpa$ = LazySequence.prototype.skip_za3lpa$;
  FilteredLazySequence.prototype.maxWith_h0x69c$ = LazySequence.prototype.maxWith_h0x69c$;
  FilteredLazySequence.prototype.minBy_mt9pj$ = LazySequence.prototype.minBy_mt9pj$;
  FilteredLazySequence.prototype.foldRemaining_b8xf17$ = LazySequence.prototype.foldRemaining_b8xf17$;
  FilteredLazySequence.prototype.distinct = LazySequence.prototype.distinct;
  FilteredLazySequence.prototype.minWith_h0x69c$ = LazySequence.prototype.minWith_h0x69c$;
  FilteredLazySequence.prototype.consumeAll = LazySequence.prototype.consumeAll;
  FilteredLazySequence.prototype.minByWith_ignqx2$ = LazySequence.prototype.minByWith_ignqx2$;
  LazySequence$Companion$of$ObjectLiteral.prototype.maxByWith_ignqx2$ = LazySequence.prototype.maxByWith_ignqx2$;
  LazySequence$Companion$of$ObjectLiteral.prototype.consumeAll = LazySequence.prototype.consumeAll;
  LazySequence$Companion$of$ObjectLiteral.prototype.minByWith_ignqx2$ = LazySequence.prototype.minByWith_ignqx2$;
  LazySequence$Companion$of$ObjectLiteral.prototype.distinctBy_2o04qz$ = LazySequence.prototype.distinctBy_2o04qz$;
  LazySequence$Companion$of$ObjectLiteral.prototype.minWith_h0x69c$ = LazySequence.prototype.minWith_h0x69c$;
  LazySequence$Companion$of$ObjectLiteral.prototype.foldRemaining_b8xf17$ = LazySequence.prototype.foldRemaining_b8xf17$;
  LazySequence$Companion$of$ObjectLiteral.prototype.maxBy_mt9pj$ = LazySequence.prototype.maxBy_mt9pj$;
  LazySequence$Companion$of$ObjectLiteral.prototype.minBy_mt9pj$ = LazySequence.prototype.minBy_mt9pj$;
  LazySequence$Companion$of$ObjectLiteral.prototype.skip_za3lpa$ = LazySequence.prototype.skip_za3lpa$;
  LazySequence$Companion$of$ObjectLiteral.prototype.distinct = LazySequence.prototype.distinct;
  LazySequence$Companion$of$ObjectLiteral.prototype.maxWith_h0x69c$ = LazySequence.prototype.maxWith_h0x69c$;
  LazySequence$Companion$fromGenerator$ObjectLiteral.prototype.skip_za3lpa$ = LazySequence.prototype.skip_za3lpa$;
  LazySequence$Companion$fromGenerator$ObjectLiteral.prototype.distinctBy_2o04qz$ = LazySequence.prototype.distinctBy_2o04qz$;
  LazySequence$Companion$fromGenerator$ObjectLiteral.prototype.minBy_mt9pj$ = LazySequence.prototype.minBy_mt9pj$;
  LazySequence$Companion$fromGenerator$ObjectLiteral.prototype.foldRemaining_b8xf17$ = LazySequence.prototype.foldRemaining_b8xf17$;
  LazySequence$Companion$fromGenerator$ObjectLiteral.prototype.maxByWith_ignqx2$ = LazySequence.prototype.maxByWith_ignqx2$;
  LazySequence$Companion$fromGenerator$ObjectLiteral.prototype.minByWith_ignqx2$ = LazySequence.prototype.minByWith_ignqx2$;
  LazySequence$Companion$fromGenerator$ObjectLiteral.prototype.maxWith_h0x69c$ = LazySequence.prototype.maxWith_h0x69c$;
  LazySequence$Companion$fromGenerator$ObjectLiteral.prototype.distinct = LazySequence.prototype.distinct;
  LazySequence$Companion$fromGenerator$ObjectLiteral.prototype.maxBy_mt9pj$ = LazySequence.prototype.maxBy_mt9pj$;
  LazySequence$Companion$fromGenerator$ObjectLiteral.prototype.consumeAll = LazySequence.prototype.consumeAll;
  LazySequence$Companion$fromGenerator$ObjectLiteral.prototype.minWith_h0x69c$ = LazySequence.prototype.minWith_h0x69c$;
  LazySequence$Companion$emptySequence$ObjectLiteral.prototype.minBy_mt9pj$ = LazySequence.prototype.minBy_mt9pj$;
  LazySequence$Companion$emptySequence$ObjectLiteral.prototype.maxByWith_ignqx2$ = LazySequence.prototype.maxByWith_ignqx2$;
  LazySequence$Companion$emptySequence$ObjectLiteral.prototype.foldRemaining_b8xf17$ = LazySequence.prototype.foldRemaining_b8xf17$;
  LazySequence$Companion$emptySequence$ObjectLiteral.prototype.minByWith_ignqx2$ = LazySequence.prototype.minByWith_ignqx2$;
  LazySequence$Companion$emptySequence$ObjectLiteral.prototype.distinct = LazySequence.prototype.distinct;
  LazySequence$Companion$emptySequence$ObjectLiteral.prototype.consumeAll = LazySequence.prototype.consumeAll;
  LazySequence$Companion$emptySequence$ObjectLiteral.prototype.maxWith_h0x69c$ = LazySequence.prototype.maxWith_h0x69c$;
  LazySequence$Companion$emptySequence$ObjectLiteral.prototype.maxBy_mt9pj$ = LazySequence.prototype.maxBy_mt9pj$;
  LazySequence$Companion$emptySequence$ObjectLiteral.prototype.minWith_h0x69c$ = LazySequence.prototype.minWith_h0x69c$;
  LazySequence$Companion$emptySequence$ObjectLiteral.prototype.distinctBy_2o04qz$ = LazySequence.prototype.distinctBy_2o04qz$;
  LazySequence$Companion$emptySequence$ObjectLiteral.prototype.skip_za3lpa$ = LazySequence.prototype.skip_za3lpa$;
  LazySequenceBuilder$SequenceImpl.prototype.minWith_h0x69c$ = LazySequence.prototype.minWith_h0x69c$;
  LazySequenceBuilder$SequenceImpl.prototype.skip_za3lpa$ = LazySequence.prototype.skip_za3lpa$;
  LazySequenceBuilder$SequenceImpl.prototype.minBy_mt9pj$ = LazySequence.prototype.minBy_mt9pj$;
  LazySequenceBuilder$SequenceImpl.prototype.maxByWith_ignqx2$ = LazySequence.prototype.maxByWith_ignqx2$;
  LazySequenceBuilder$SequenceImpl.prototype.maxWith_h0x69c$ = LazySequence.prototype.maxWith_h0x69c$;
  LazySequenceBuilder$SequenceImpl.prototype.distinctBy_2o04qz$ = LazySequence.prototype.distinctBy_2o04qz$;
  LazySequenceBuilder$SequenceImpl.prototype.distinct = LazySequence.prototype.distinct;
  LazySequenceBuilder$SequenceImpl.prototype.maxBy_mt9pj$ = LazySequence.prototype.maxBy_mt9pj$;
  LazySequenceBuilder$SequenceImpl.prototype.consumeAll = LazySequence.prototype.consumeAll;
  LazySequenceBuilder$SequenceImpl.prototype.foldRemaining_b8xf17$ = LazySequence.prototype.foldRemaining_b8xf17$;
  LazySequenceBuilder$SequenceImpl.prototype.minByWith_ignqx2$ = LazySequence.prototype.minByWith_ignqx2$;
  MappedLazySequence.prototype.minBy_mt9pj$ = LazySequence.prototype.minBy_mt9pj$;
  MappedLazySequence.prototype.consumeAll = LazySequence.prototype.consumeAll;
  MappedLazySequence.prototype.distinctBy_2o04qz$ = LazySequence.prototype.distinctBy_2o04qz$;
  MappedLazySequence.prototype.maxWith_h0x69c$ = LazySequence.prototype.maxWith_h0x69c$;
  MappedLazySequence.prototype.foldRemaining_b8xf17$ = LazySequence.prototype.foldRemaining_b8xf17$;
  MappedLazySequence.prototype.minByWith_ignqx2$ = LazySequence.prototype.minByWith_ignqx2$;
  MappedLazySequence.prototype.skip_za3lpa$ = LazySequence.prototype.skip_za3lpa$;
  MappedLazySequence.prototype.distinct = LazySequence.prototype.distinct;
  MappedLazySequence.prototype.maxBy_mt9pj$ = LazySequence.prototype.maxBy_mt9pj$;
  MappedLazySequence.prototype.minWith_h0x69c$ = LazySequence.prototype.minWith_h0x69c$;
  MappedLazySequence.prototype.maxByWith_ignqx2$ = LazySequence.prototype.maxByWith_ignqx2$;
  AndQuery.prototype.findProofWithin_5dl3t6$ = Query.prototype.findProofWithin_5dl3t6$;
  OrQuery.prototype.findProofWithin_5dl3t6$ = Query.prototype.findProofWithin_5dl3t6$;
  PredicateQuery.prototype.findProofWithin_5dl3t6$ = Query.prototype.findProofWithin_5dl3t6$;
  Atom.prototype.unify_dtn93p$ = Term.prototype.unify_dtn93p$;
  Number_0.prototype.unify_dtn93p$ = Term.prototype.unify_dtn93p$;
  Decimal.prototype.unify_dtn93p$ = Term.prototype.unify_dtn93p$;
  Integer.prototype.unify_dtn93p$ = Term.prototype.unify_dtn93p$;
  List_0.prototype.unify_dtn93p$ = Term.prototype.unify_dtn93p$;
  surrogateVarLHS = new Variable('LHS');
  surrogateVarRHS = new Variable('RHS');
  A = new Variable('A');
  B = new Variable('B');
  X = new Variable('X');
  EqualityLibrary = new EqualityLibrary$ObjectLiteral(new DoublyIndexedLibraryEntryStore(), DefaultOperatorRegistry_init());
  MathLibrary = new MathLibrary$ObjectLiteral(new DoublyIndexedLibraryEntryStore(), DefaultOperatorRegistry_init());
  TypeSafetyLibrary = new TypeSafetyLibrary$ObjectLiteral(new DoublyIndexedLibraryEntryStore(), DefaultOperatorRegistry_init());
  Kotlin.defineModule('runtime-core-js', _);
  return _;
}(typeof this['runtime-core-js'] === 'undefined' ? {} : this['runtime-core-js'], kotlin);

//# sourceMappingURL=runtime-core-js.js.map
