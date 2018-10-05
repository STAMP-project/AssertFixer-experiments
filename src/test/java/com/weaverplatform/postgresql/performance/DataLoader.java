package com.weaverplatform.postgresql.performance;

import com.google.common.collect.Lists;
import com.weaverplatform.postgresql.database.Postgres;
import com.weaverplatform.protocol.model.*;
import cool.graph.cuid.Cuid;
import org.apache.commons.lang3.time.StopWatch;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Mohamad Alamili
 */
public class DataLoader {

  public static void main(String[] args){
    new DataLoader();
  }

  private final static String DATABASE_NAME = "postgres";

  private Random randomGenerator = new Random();
  private NounGenerator nounGenerator = new NounGenerator("nouns.txt");

  private List<String>
    nodes               = new ArrayList<>(),
    attributes          = new ArrayList<>(),
    relations           = new ArrayList<>(),
    replacedAttributes  = new ArrayList<>(),
    replacedRelations   = new ArrayList<>(),
    removedAttributes   = new ArrayList<>(),
    removedRelations    = new ArrayList<>(),
    removedNodes        = new ArrayList<>(),
    attributeKeys       = new ArrayList<>(),
    relationKeys        = new ArrayList<>(),
    users               = new ArrayList<>();

  final int MAX_CREATORS        = 100;
  final int MAX_NODES           = 100;
  final int ATTRIBUTES_PER_NODE = 5;
  final int RELATIONS_PER_NODE  = 3;

  final int MAX_ATTRIBUTE_KEYS  = 200;
  final int MAX_RELATION_KEYS   = 200;

  final int REPLACED_ATTRIBUTES_PERCENTAGE = 70;
  final int REPLACED_RELATIONS_PERCENTAGE  = 70;

  final int REMOVED_ATTRIBUTES_PERCENTAGE  = 10;
  final int REMOVED_RELATIONS_PERCENTAGE   = 10;
  final int REMOVED_NODES_PERCENTAGE       = 20;

  final int WOP_BATCH_SIZE = 500;

  public DataLoader() {
    wipe();

    // Create bunch of nodes based on the settings
    fill(users, MAX_CREATORS);
    fill(nodes, MAX_NODES);
    fill(attributes, MAX_NODES * ATTRIBUTES_PER_NODE);
    fill(relations, MAX_NODES * RELATIONS_PER_NODE);

    fill(attributeKeys, MAX_ATTRIBUTE_KEYS, () -> nounGenerator.getSomeNouns());
    fill(relationKeys,  MAX_RELATION_KEYS, () -> nounGenerator.getSomeNouns());

    fill(replacedAttributes, attributes.size() * REPLACED_ATTRIBUTES_PERCENTAGE / 100);
    fill(replacedRelations, relations.size() * REPLACED_RELATIONS_PERCENTAGE / 100);

    fill(removedAttributes, (attributes.size() + replacedAttributes.size()) * REMOVED_ATTRIBUTES_PERCENTAGE / 100);
    fill(removedRelations, (relations.size() + replacedRelations.size()) * REMOVED_RELATIONS_PERCENTAGE / 100);
    fill(removedNodes, nodes.size() * REMOVED_NODES_PERCENTAGE / 100);

    System.out.println();

    // Nodes
    send("nodes", nodes, (n) ->
      new CreateNodeOperation(random(users), n));

    // String attributes
    List<List<String>> attrPartitions = Lists.partition(attributes, attributes.size() / 4);

    send("string attributes", attrPartitions.get(0), (a) ->
      new CreateAttributeOperation(random(users), a, random(nodes), random(attributeKeys), nounGenerator.getSomeNouns(), AttributeDataType.STRING));

    send("boolean attributes", attrPartitions.get(1), (a) ->
      new CreateAttributeOperation(random(users), a, random(nodes), random(attributeKeys), randomBoolean(), AttributeDataType.BOOLEAN));

    send("double attributes", attrPartitions.get(2), (a) ->
      new CreateAttributeOperation(random(users), a, random(nodes), random(attributeKeys), randomDouble(), AttributeDataType.DOUBLE));

    send("datetime attributes", attrPartitions.get(3), (a) ->
      new CreateAttributeOperation(random(users), a, random(nodes), random(attributeKeys), randomDate(), AttributeDataType.DATE));


    Set<String> pickedReplacingAttributes = new HashSet<>();
    List<List<String>> replacingAttrPartitions = Lists.partition(replacedAttributes, replacedAttributes.size() / 4);

    send("replacing with string attributes", replacingAttrPartitions.get(0), (a) ->
      new CreateAttributeOperation(random(users), a, random(nodes), random(attributeKeys), nounGenerator.getSomeNouns(), AttributeDataType.STRING, Cuid.createCuid(), randomString(attributes, pickedReplacingAttributes)));

    send("replacing with boolean attributes", replacingAttrPartitions.get(1), (a) ->
      new CreateAttributeOperation(random(users), a, random(nodes), random(attributeKeys), randomBoolean(), AttributeDataType.BOOLEAN, Cuid.createCuid(), randomString(attributes, pickedReplacingAttributes)));

    send("replacing with double attributes", replacingAttrPartitions.get(2), (a) ->
      new CreateAttributeOperation(random(users), a, random(nodes), random(attributeKeys), randomDouble(), AttributeDataType.DOUBLE, Cuid.createCuid(), randomString(attributes, pickedReplacingAttributes)));

    send("replacing with datetime attributes", replacingAttrPartitions.get(3), (a) ->
      new CreateAttributeOperation(random(users), a, random(nodes), random(attributeKeys), randomDate(), AttributeDataType.DATE, Cuid.createCuid(), randomString(attributes, pickedReplacingAttributes)));


    send("relations", relations, (r) ->
      new CreateRelationOperation(random(users), r, random(nodes), random(relationKeys), random(nodes)));

    Set<String> pickedReplacingRelations = new HashSet<>();
    send("replacing relations", replacedRelations, (r) ->
      new CreateRelationOperation(random(users), r, random(nodes), random(relationKeys), random(nodes), Cuid.createCuid(), randomString(relations, pickedReplacingRelations)));

    List<String> allAttributes =new ArrayList<>();
    allAttributes.addAll(attributes);
    allAttributes.addAll(replacedAttributes);

    Set<String> pickedAttributes = new HashSet<>();
    send("removing attributes", removedAttributes, (r) ->
      new RemoveAttributeOperation(random(users), randomString(allAttributes, pickedAttributes), r));

    List<String> allRelations =new ArrayList<>();
    allRelations.addAll(relations);
    allRelations.addAll(replacedRelations);

    Set<String> pickedRelations = new HashSet<>();
    send("removing relations", removedRelations, (r) ->
      new RemoveRelationOperation(random(users), randomString(allRelations, pickedRelations), r));

    Set<String> pickedNodes = new HashSet<>();
    send("removing nodes", removedNodes, (r) ->
      new RemoveNodeOperation(random(users), randomString(nodes, pickedNodes), r));
  }



  public void wipe(){
    System.out.println("Wiping database...");
    Postgres.INSTANCE.getDatabase(DATABASE_NAME).wipe();
    System.out.println();
  }


  public void send(String type, List<String> elements, ComposeWriteOperation cwo){
    List<WriteOperation> operations = elements.stream().map(cwo::compose).collect(Collectors.toList());

    // Split it up in batches
    List<List<WriteOperation>> partitions = Lists.partition(operations, WOP_BATCH_SIZE);

    for (int i=0; i < partitions.size(); i++){
      List<WriteOperation> part = partitions.get(i);
      System.out.print("Sending " +part.size() + " " + type + " ("+ (i+1) + "/"+ partitions.size() +")...");

      StopWatch sw = new StopWatch();
      sw.start();

      Postgres.INSTANCE.getDatabase(DATABASE_NAME).write(part);

      sw.stop();
      System.out.println("(" + sw.getTime() + " ms)");
    }
    System.out.println();
  }

  public String randomString(List<String> list, Set<String> selected){
    int len = list.size();
    int randomInt = randomGenerator.nextInt(len);
    String element = list.get(randomInt);

    if(selected == null){
      return element;
    }

    if(selected.contains(element)){
      return randomString(list, selected);
    }
    else {
      selected.add(element);
      return element;
    }
  }

  public boolean randomBoolean(){
    int randomInt = randomGenerator.nextInt(2);
    return randomInt == 1;
  }

  public double randomDouble(){
    double randomDouble = randomGenerator.nextDouble();
    int randomInt = randomGenerator.nextInt(1000);

    return (double) ((int) (randomDouble * randomInt));
  }


  public double randomDate(){
    long now = System.currentTimeMillis();
    int randomInt = randomGenerator.nextInt((60 * 60 * 24 * 5000 * 100));
    return now - randomInt * 10;
  }

  public String random(List<String> list){
    return randomString(list, null);
  }

  public void fill(List<String> list, int max) {
    fill(list, max, () -> Cuid.createCuid());
  }

  public void fill(List<String> list, int max, WordGenerator generator) {
    System.out.println("Filling "+ max +" nodes...");

    for (int i = 0; i < max; i++){
      list.add(generator.generate());
    }
  }

  @FunctionalInterface
  public interface ComposeWriteOperation {
    WriteOperation compose(String id);
  }

  @FunctionalInterface
  public interface WordGenerator {
    String generate();
  }
}
