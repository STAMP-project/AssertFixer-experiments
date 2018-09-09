// code by ynager
package ch.ethz.idsc.owl.bot.tse2;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import ch.ethz.idsc.owl.bot.r2.ImageEdges;
import ch.ethz.idsc.owl.bot.se2.LidarEmulator;
import ch.ethz.idsc.owl.bot.se2.glc.Se2Demo;
import ch.ethz.idsc.owl.bot.se2.glc.SimpleShadowConstraintCV;
import ch.ethz.idsc.owl.bot.util.FlowsInterface;
import ch.ethz.idsc.owl.glc.adapter.EtaRaster;
import ch.ethz.idsc.owl.glc.adapter.GlcExpand;
import ch.ethz.idsc.owl.glc.adapter.GlcTrajectories;
import ch.ethz.idsc.owl.glc.adapter.MultiConstraintAdapter;
import ch.ethz.idsc.owl.glc.adapter.MultiCostGoalAdapter;
import ch.ethz.idsc.owl.glc.adapter.RegionConstraints;
import ch.ethz.idsc.owl.glc.core.CostFunction;
import ch.ethz.idsc.owl.glc.core.GlcNode;
import ch.ethz.idsc.owl.glc.core.GoalInterface;
import ch.ethz.idsc.owl.glc.core.PlannerConstraint;
import ch.ethz.idsc.owl.glc.core.StateTimeRaster;
import ch.ethz.idsc.owl.glc.core.TrajectoryPlanner;
import ch.ethz.idsc.owl.glc.std.StandardTrajectoryPlanner;
import ch.ethz.idsc.owl.gui.ani.GlcPlannerCallback;
import ch.ethz.idsc.owl.gui.region.EllipseRegionRender;
import ch.ethz.idsc.owl.gui.region.ImageRender;
import ch.ethz.idsc.owl.gui.ren.TrajectoryRender;
import ch.ethz.idsc.owl.gui.ren.TreeRender;
import ch.ethz.idsc.owl.gui.win.OwlyAnimationFrame;
import ch.ethz.idsc.owl.mapping.ShadowEvaluator;
import ch.ethz.idsc.owl.mapping.ShadowMapDirected;
import ch.ethz.idsc.owl.mapping.ShadowMapSpherical;
import ch.ethz.idsc.owl.math.StateTimeTensorFunction;
import ch.ethz.idsc.owl.math.flow.Flow;
import ch.ethz.idsc.owl.math.region.ImageRegion;
import ch.ethz.idsc.owl.math.region.SphericalRegion;
import ch.ethz.idsc.owl.math.state.FixedStateIntegrator;
import ch.ethz.idsc.owl.math.state.SimpleTrajectoryRegionQuery;
import ch.ethz.idsc.owl.math.state.StateTime;
import ch.ethz.idsc.owl.math.state.TrajectoryRegionQuery;
import ch.ethz.idsc.owl.math.state.TrajectorySample;
import ch.ethz.idsc.owl.sim.LidarRaytracer;
import ch.ethz.idsc.subare.util.Stopwatch;
import ch.ethz.idsc.tensor.DoubleScalar;
import ch.ethz.idsc.tensor.RationalScalar;
import ch.ethz.idsc.tensor.RealScalar;
import ch.ethz.idsc.tensor.Scalar;
import ch.ethz.idsc.tensor.Tensor;
import ch.ethz.idsc.tensor.Tensors;
import ch.ethz.idsc.tensor.alg.Subdivide;
import ch.ethz.idsc.tensor.io.ImageFormat;
import ch.ethz.idsc.tensor.io.ResourceData;
import ch.ethz.idsc.tensor.qty.Degree;
import ch.ethz.idsc.tensor.sca.Sqrt;

public class PlanningEvaluation0 extends Se2Demo {
  // Entity Stuff
  static final int ID = 1;
  //
  static final boolean SR_PED_LEGAL = false;
  static final boolean SR_PED_ILLEGAL = false;
  static final boolean SR_CAR = false;
  static final boolean EVAL_PED_LEGAL = false;
  static final boolean EVAL_PED_ILLEGAL = false;
  static final boolean EVAL_CAR = false;
  //
  static final Scalar MAX_SPEED = RealScalar.of(8); // 8
  static final Scalar MAX_TURNING_PLAN = Degree.of(20); // 45
  static final FlowsInterface TSE2_CARFLOWS = Tse2CarFlows.of(MAX_TURNING_PLAN, Tensors.vector(-1, 0, 1));
  static final int FLOWRES = 9;
  static final StateTime INITIAL = new StateTime(Tensors.vector(12, 3.0, 1.571, 8), RealScalar.ZERO);
  static final Tensor PARTITIONSCALE = Tensors.of( //
      RealScalar.of(2), RealScalar.of(2), Degree.of(10).reciprocal(), RealScalar.of(10)).unmodifiable();
  // static final Tensor GOAL = Tensors.vector(20, 33.5, 0, MAX_SPEED.number()); // around curve
  static final Tensor GOAL = Tensors.vector(12, 30, 1.571, MAX_SPEED.number()); // only straigh
  final Tensor goalRadius;
  //
  static final float PED_VELOCITY = 2.0f;
  static final float CAR_VELOCITY = 4;
  static final float PED_RADIUS = 0.3f;
  static final float MAX_A = 5.0f; // [m/s²]
  static final float REACTION_TIME = 0.0f;
  static final Tensor RANGE = Tensors.vector(30.5, 43.1);
  static final LidarRaytracer LIDAR_RAYTRACER = //
      new LidarRaytracer(Subdivide.of(Degree.of(-180), Degree.of(180), 72), Subdivide.of(0, 30, 90));
  //
  static final int MAX_STEPS = 10000;
  static final FixedStateIntegrator FIXEDSTATEINTEGRATOR = // node interval == 2/5
      FixedStateIntegrator.create(Tse2Integrator.INSTANCE, RationalScalar.of(1, 10), 4);
  final Collection<Flow> controls;
  final Collection<CostFunction> extraCosts = new LinkedList<>();

  public PlanningEvaluation0() {
    final Scalar goalRadius_xy = DoubleScalar.of(1.2); // Sqrt.of(RealScalar.of(2)).divide(PARTITIONSCALE.Get(0));
    final Scalar goalRadius_theta = Sqrt.of(RealScalar.of(2)).divide(RealScalar.of(20)); // SQRT2.divide(PARTITIONSCALE.Get(2));
    final Scalar goalRadius_v = RealScalar.of(12); // SQRT2.divide(PARTITIONSCALE.Get(3));
    this.goalRadius = Tensors.of(goalRadius_xy, goalRadius_xy, goalRadius_theta, goalRadius_v);
    this.controls = TSE2_CARFLOWS.getFlows(FLOWRES);
  }

  @Override
  protected void configure(OwlyAnimationFrame owlyAnimationFrame) {
    // ---
    Tensor image = ResourceData.of("/simulation/s3/render.png");
    BufferedImage bufferedImage = ImageFormat.of(image);
    //
    ImageRender imgRender = ImageRender.of(bufferedImage, RANGE);
    owlyAnimationFrame.addBackground(imgRender);
    //
    // IMAGE REGIONS
    Tensor imagePedLegal = ResourceData.of("/simulation/s3/ped_obs_legal.png");
    Tensor imagePedIllegal = ResourceData.of("/simulation/s3/ped_obs_illegal.png");
    Tensor imageCar = ResourceData.of("/simulation/s3/car_obs_1.png");
    imageCar = ImageEdges.extrusion(imageCar, 10);
    Tensor imageLid = ResourceData.of("/simulation/s3/lidar_obs.png");
    ImageRegion irPedLegal = new ImageRegion(imagePedLegal, RANGE, false);
    ImageRegion irPedIllegal = new ImageRegion(imagePedIllegal, RANGE, false);
    ImageRegion irCar = new ImageRegion(imageCar, RANGE, false);
    ImageRegion irLid = new ImageRegion(imageLid, RANGE, false);
    //
    // SETUP CONSTRAINTS
    List<PlannerConstraint> constraints = new ArrayList<>();
    constraints.add(RegionConstraints.timeInvariant(irCar));
    constraints.add(new Tse2VelocityConstraint(RealScalar.ZERO, MAX_SPEED));
    PlannerConstraint plannerConstraints = MultiConstraintAdapter.of(constraints);
    //
    // LIDAR EMULATOR
    TrajectoryRegionQuery lidarRay = SimpleTrajectoryRegionQuery.timeInvariant(irLid);
    LidarEmulator lidarEmulator = new LidarEmulator( //
        LIDAR_RAYTRACER, () -> new StateTime(Tensors.vector(0, 0, 0), RealScalar.ZERO), lidarRay);
    owlyAnimationFrame.addBackground(lidarEmulator);
    // SHADOW REGIONS
    ShadowMapSpherical smPedLegal = //
        new ShadowMapSpherical(lidarEmulator, irPedLegal, PED_VELOCITY, PED_RADIUS);
    ShadowMapSpherical smPedIllegal = //
        new ShadowMapSpherical(lidarEmulator, irPedIllegal, PED_VELOCITY, PED_RADIUS);
    ShadowMapDirected smCar = new ShadowMapDirected( //
        lidarEmulator, irCar, "/simulation/s3/car_lanes.png", CAR_VELOCITY);
    //
    // SHADOW REGION CONSTRAINTS
    if (SR_PED_LEGAL) {
      PlannerConstraint pedLegalConst = new SimpleShadowConstraintCV(smPedLegal, irCar, MAX_A, REACTION_TIME, true);
      constraints.add(pedLegalConst);
    }
    if (SR_PED_ILLEGAL) {
      PlannerConstraint pedIllegalConst = new SimpleShadowConstraintCV(smPedIllegal, irCar, MAX_A, REACTION_TIME, true);
      constraints.add(pedIllegalConst);
    }
    if (SR_CAR) {
      PlannerConstraint carConst = new SimpleShadowConstraintCV(smCar, irCar, MAX_A, REACTION_TIME, true);
      constraints.add(carConst);
    }
    //
    // SETUP PLANNER
    Tse2ComboRegion tse2ComboRegion = Tse2ComboRegion.spherical(GOAL, goalRadius);
    Tse2MinTimeGoalManager tse2MinTimeGoalManager = new Tse2MinTimeGoalManager(tse2ComboRegion, controls, MAX_SPEED);
    GoalInterface goalInterface = MultiCostGoalAdapter.of(tse2MinTimeGoalManager.getGoalInterface(), extraCosts);
    owlyAnimationFrame.addBackground(EllipseRegionRender.of(new SphericalRegion(GOAL, goalRadius.Get(0))));
    TrajectoryPlanner tp = new StandardTrajectoryPlanner( //
        stateTimeRaster(), FIXEDSTATEINTEGRATOR, controls, plannerConstraints, goalInterface);
    // SETUP CALLBACKS
    List<GlcPlannerCallback> callbacks = new ArrayList<>();
    //
    // EVALUATOR
    if (EVAL_PED_LEGAL) {
      ShadowEvaluator evaluator = new ShadowEvaluator(smPedLegal, RealScalar.of(MAX_A), "legal" + String.valueOf(ID));
      callbacks.add(evaluator.sectorTimeToReact);
    }
    if (EVAL_PED_ILLEGAL) {
      ShadowEvaluator evaluator = new ShadowEvaluator(smPedIllegal, RealScalar.of(MAX_A), "illegal" + String.valueOf(ID));
      callbacks.add(evaluator.sectorTimeToReact);
    }
    if (EVAL_CAR) {
      ShadowEvaluator evaluator = new ShadowEvaluator(smCar, RealScalar.of(MAX_A), "ped" + String.valueOf(ID));
      callbacks.add(evaluator.sectorTimeToReact);
    }
    //
    // MOTION PLAN WORKER
    Thread mpw = new Thread(new Runnable() {
      @Override // from Runnable
      public void run() {
        Stopwatch stopwatch = Stopwatch.started();
        tp.insertRoot(INITIAL);
        GlcExpand glcExpand = new GlcExpand(tp);
        glcExpand.findAny(MAX_STEPS);
        stopwatch.stop();
        System.out.println("Planning time: " + stopwatch.display_seconds());
        //
        Optional<GlcNode> optional = tp.getBest();
        if (optional.isPresent()) {
          System.out.println("Cost to Goal: " + optional.get().costFromRoot());
          List<TrajectorySample> traj = //
              GlcTrajectories.detailedTrajectoryTo(tp.getStateIntegrator(), optional.get());
          owlyAnimationFrame.addBackground(new TreeRender(tp.getDomainMap().values()));
          TrajectoryRender trajectoryRender = new TrajectoryRender();
          trajectoryRender.trajectory(traj);
          trajectoryRender.setColor(Color.GREEN);
          owlyAnimationFrame.addBackground(trajectoryRender);
        } else {
          System.out.println("no traj found");
        }
        for (GlcPlannerCallback glcPlannerCallback : callbacks)
          glcPlannerCallback.expandResult(Collections.emptyList(), tp);
      }
    });
    System.out.println("Planning...");
    mpw.start();
  }

  protected StateTimeRaster stateTimeRaster() {
    return new EtaRaster(PARTITIONSCALE, StateTimeTensorFunction.state(Tse2Wrap.INSTANCE::represent));
  }

  public static void main(String[] args) {
    new PlanningEvaluation0().start().jFrame.setVisible(true);
  }
}
