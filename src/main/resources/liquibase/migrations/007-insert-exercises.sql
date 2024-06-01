-- Abdominals
INSERT INTO public.exercises (name, equipment, instructions, category_id, duration, burn_calories) VALUES
                                                                                                       ('Crunches', 'None', 'Lie on your back with knees bent, lift your shoulders off the ground.', 1, 10, 50),
                                                                                                       ('Leg Raises', 'None', 'Lie on your back, lift your legs to a 90-degree angle.', 1, 12, 60),
                                                                                                       ('Plank', 'None', 'Hold a push-up position, maintaining a straight line.', 1, 5, 35),
                                                                                                       ('Russian Twists', 'Medicine Ball', 'Sit on the floor, twist your torso side to side.', 1, 15, 80),
                                                                                                       ('Bicycle Crunches', 'None', 'Lie on your back, bring opposite elbow to knee.', 1, 12, 75);

-- Abductors
INSERT INTO public.exercises (name, equipment, instructions, category_id, duration, burn_calories) VALUES
                                                                                                       ('Side-Lying Leg Lift', 'None', 'Lie on your side, lift the top leg up and down.', 2, 10, 45),
                                                                                                       ('Cable Hip Abduction', 'Cable Machine', 'Stand with a cable attached to your ankle, move leg away from body.', 2, 12, 55),
                                                                                                       ('Standing Leg Lift', 'None', 'Stand and lift one leg out to the side.', 2, 8, 40),
                                                                                                       ('Band Walks', 'Resistance Band', 'Place a band around your legs, step side to side.', 2, 10, 50),
                                                                                                       ('Lateral Step-Up', 'Box', 'Step up onto a box sideways.', 2, 12, 60);

-- Adductors
INSERT INTO public.exercises (name, equipment, instructions, category_id, duration, burn_calories) VALUES
                                                                                                       ('Sumo Squat', 'Dumbbell', 'Squat with legs wide apart.', 3, 10, 70),
                                                                                                       ('Cable Hip Adduction', 'Cable Machine', 'Stand with a cable attached to your ankle, move leg toward body.', 3, 12, 65),
                                                                                                       ('Side-Lying Inner Leg Lift', 'None', 'Lie on your side, lift the bottom leg up.', 3, 8, 50),
                                                                                                       ('Adductor Machine', 'Machine', 'Sit and push the pads together with your legs.', 3, 10, 55),
                                                                                                       ('Cossack Squat', 'None', 'Squat down to one side while keeping the other leg straight.', 3, 15, 80);

-- Biceps
INSERT INTO public.exercises (name, equipment, instructions, category_id, duration, burn_calories) VALUES
                                                                                                       ('Bicep Curl', 'Dumbbell', 'Curl the dumbbells up to shoulder height.', 4, 10, 40),
                                                                                                       ('Hammer Curl', 'Dumbbell', 'Curl the dumbbells with palms facing each other.', 4, 12, 45),
                                                                                                       ('Concentration Curl', 'Dumbbell', 'Sit and curl the dumbbell up to shoulder.', 4, 8, 35),
                                                                                                       ('Cable Curl', 'Cable Machine', 'Curl the cable handle to your shoulders.', 4, 10, 50),
                                                                                                       ('Preacher Curl', 'EZ Curl Bar', 'Curl the barbell on a preacher bench.', 4, 12, 55);

-- Calves
INSERT INTO public.exercises (name, equipment, instructions, category_id, duration, burn_calories) VALUES
                                                                                                       ('Standing Calf Raise', 'None', 'Stand and lift your heels off the ground.', 5, 10, 30),
                                                                                                       ('Seated Calf Raise', 'Machine', 'Sit and lift the weight with your toes.', 5, 12, 35),
                                                                                                       ('Calf Press on Leg Press Machine', 'Leg Press Machine', 'Press the weight with the balls of your feet.', 5, 10, 40),
                                                                                                       ('Donkey Calf Raise', 'Machine', 'Bend over and lift your heels with weight on your back.', 5, 10, 45),
                                                                                                       ('Single-Leg Calf Raise', 'None', 'Lift your heel off the ground one leg at a time.', 5, 8, 30);

-- Chest
INSERT INTO public.exercises (name, equipment, instructions, category_id, duration, burn_calories) VALUES
                                                                                                       ('Bench Press', 'Barbell', 'Press the barbell up from your chest.', 6, 15, 100),
                                                                                                       ('Push-Up', 'None', 'Lower and lift your body using your arms.', 6, 10, 60),
                                                                                                       ('Chest Fly', 'Dumbbell', 'Lie on a bench and open and close your arms.', 6, 12, 70),
                                                                                                       ('Incline Bench Press', 'Barbell', 'Press the barbell up from an inclined position.', 6, 15, 90),
                                                                                                       ('Cable Crossover', 'Cable Machine', 'Pull the cable handles together in front of your chest.', 6, 12, 80);

-- Forearms
INSERT INTO public.exercises (name, equipment, instructions, category_id, duration, burn_calories) VALUES
                                                                                                       ('Wrist Curl', 'Dumbbell', 'Curl the dumbbell with your wrist.', 7, 8, 35),
                                                                                                       ('Reverse Wrist Curl', 'Dumbbell', 'Curl the dumbbell upward with your wrist.', 7, 10, 40),
                                                                                                       ('Farmer’s Walk', 'Dumbbell', 'Walk holding heavy dumbbells.', 7, 12, 55),
                                                                                                       ('Finger Curl', 'Barbell', 'Curl the barbell with your fingers.', 7, 10, 45),
                                                                                                       ('Towel Grip Pull-Up', 'Towel', 'Do pull-ups holding towels.', 7, 8, 50);

-- Glutes
INSERT INTO public.exercises (name, equipment, instructions, category_id, duration, burn_calories) VALUES
                                                                                                       ('Glute Bridge', 'None', 'Lift your hips off the ground while lying on your back.', 8, 12, 70),
                                                                                                       ('Hip Thrust', 'Barbell', 'Lift your hips with a barbell across your lap.', 8, 15, 90),
                                                                                                       ('Lunge', 'Dumbbell', 'Step forward and lower your back knee.', 8, 10, 65),
                                                                                                       ('Step-Up', 'Box', 'Step up onto a box with one leg.', 8, 12, 75),
                                                                                                       ('Squat', 'Barbell', 'Lower your body into a sitting position.', 8, 15, 85);

-- Hamstrings
INSERT INTO public.exercises (name, equipment, instructions, category_id, duration, burn_calories) VALUES
                                                                                                       ('Deadlift', 'Barbell', 'Lift the barbell off the ground.', 9, 15, 110),
                                                                                                       ('Leg Curl', 'Machine', 'Curl the weight towards your buttocks.', 9, 10, 60),
                                                                                                       ('Romanian Deadlift', 'Barbell', 'Lower and lift the barbell keeping your legs straight.', 9, 12, 90),
                                                                                                       ('Good Morning', 'Barbell', 'Bend forward at the hips with a barbell on your back.', 9, 10, 75),
                                                                                                       ('Single-Leg Deadlift', 'Dumbbell', 'Lift one leg back while lowering your torso.', 9, 12, 85);

-- Lats
INSERT INTO public.exercises (name, equipment, instructions, category_id, duration, burn_calories) VALUES
                                                                                                       ('Pull-Up', 'None', 'Lift your body up to the bar.', 10, 15, 100),
                                                                                                       ('Lat Pulldown', 'Cable Machine', 'Pull the bar down to your chest.', 10, 12, 85),
                                                                                                       ('Bent Over Row', 'Barbell', 'Row the barbell to your waist.', 10, 10, 80),
                                                                                                       ('T-Bar Row', 'Barbell', 'Row the T-bar towards your chest.', 10, 12, 90),
                                                                                                       ('Single-Arm Dumbbell Row', 'Dumbbell', 'Row the dumbbell to your waist.', 10, 15, 95);

-- Lower Back
INSERT INTO public.exercises (name, equipment, instructions, category_id, duration, burn_calories) VALUES
                                                                                                       ('Back Extension', 'Hyperextension Bench', 'Extend your back upwards.', 11, 10, 60),
                                                                                                       ('Deadlift', 'Barbell', 'Lift the barbell off the ground.', 11, 15, 100),
                                                                                                       ('Superman', 'None', 'Lift your arms and legs while lying on your stomach.', 11, 8, 50),
                                                                                                       ('Good Morning', 'Barbell', 'Bend forward at the hips with a barbell on your back.', 11, 10, 70),
                                                                                                       ('Kettlebell Swing', 'Kettlebell', 'Swing the kettlebell between your legs and up.', 11, 12, 80);

-- Middle Back
INSERT INTO public.exercises (name, equipment, instructions, category_id, duration, burn_calories) VALUES
                                                                                                       ('Seated Cable Row', 'Cable Machine', 'Row the cable handle to your waist.', 12, 10, 75),
                                                                                                       ('Bent Over Row', 'Barbell', 'Row the barbell to your waist.', 12, 12, 85),
                                                                                                       ('T-Bar Row', 'Barbell', 'Row the T-bar towards your chest.', 12, 10, 80),
                                                                                                       ('Single-Arm Dumbbell Row', 'Dumbbell', 'Row the dumbbell to your waist.', 12, 12, 90),
                                                                                                       ('Inverted Row', 'Bar', 'Pull your chest up to the bar while hanging.', 12, 15, 95);

-- Neck
INSERT INTO public.exercises (name, equipment, instructions, category_id, duration, burn_calories) VALUES
                                                                                                       ('Neck Flexion', 'Head Harness', 'Flex your neck forward.', 13, 8, 40),
                                                                                                       ('Neck Extension', 'Head Harness', 'Extend your neck backward.', 13, 10, 45),
                                                                                                       ('Side Neck Flexion', 'Head Harness', 'Flex your neck to the side.', 13, 10, 50),
                                                                                                       ('Shrugs', 'Dumbbell', 'Lift your shoulders towards your ears.', 13, 12, 55),
                                                                                                       ('Neck Bridge', 'None', 'Bridge your body on your head and feet.', 13, 8, 30);

-- Quadriceps
INSERT INTO public.exercises (name, equipment, instructions, category_id, duration, burn_calories) VALUES
                                                                                                       ('Squat', 'Barbell', 'Lower your body into a sitting position.', 14, 15, 90),
                                                                                                       ('Leg Press', 'Machine', 'Press the weight with your feet.', 14, 12, 85),
                                                                                                       ('Lunge', 'Dumbbell', 'Step forward and lower your back knee.', 14, 10, 70),
                                                                                                       ('Leg Extension', 'Machine', 'Extend your legs out straight.', 14, 12, 75),
                                                                                                       ('Step-Up', 'Box', 'Step up onto a box with one leg.', 14, 10, 65);

-- Traps
INSERT INTO public.exercises (name, equipment, instructions, category_id, duration, burn_calories) VALUES
                                                                                                       ('Shrugs', 'Dumbbell', 'Lift your shoulders towards your ears.', 15, 10, 55),
                                                                                                       ('Upright Row', 'Barbell', 'Row the barbell up to your chin.', 15, 12, 70),
                                                                                                       ('Farmer’s Walk', 'Dumbbell', 'Walk holding heavy dumbbells.', 15, 10, 60),
                                                                                                       ('Face Pull', 'Cable Machine', 'Pull the cable handle to your face.', 15, 10, 65),
                                                                                                       ('Rack Pull', 'Barbell', 'Lift the barbell just below knee height.', 15, 15, 80);

-- Triceps
INSERT INTO public.exercises (name, equipment, instructions, category_id, duration, burn_calories) VALUES
                                                                                                       ('Tricep Extension', 'Dumbbell', 'Extend the dumbbell overhead.', 16, 12, 65),
                                                                                                       ('Tricep Pushdown', 'Cable Machine', 'Push the cable handle down.', 16, 10, 60),
                                                                                                       ('Dips', 'Parallel Bars', 'Lower and lift your body using your arms.', 16, 15, 75),
                                                                                                       ('Close Grip Bench Press', 'Barbell', 'Press the barbell with a narrow grip.', 16, 12, 70),
                                                                                                       ('Skull Crusher', 'EZ Curl Bar', 'Lower the bar to your forehead and extend.', 16, 10, 65);

