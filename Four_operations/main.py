import argparse
import random
from fractions import Fraction


# 生成四则运算题目
def generate_question(range_value, operator_count=3):
    operators = ['+', '-', '*', '/']
    numbers = []

    # 随机生成自然数或真分数
    for _ in range(operator_count + 1):
        if random.choice([True, False]):
            numerator = random.randint(1, range_value - 1)
            denominator = random.randint(2, range_value)
            fraction = Fraction(numerator, denominator)
            numbers.append(fraction)
        else:
            numbers.append(random.randint(1, range_value - 1))

    expression = str(numbers[0])
    for i in range(operator_count):
        op = random.choice(operators)
        expression += f" {op} {numbers[i + 1]}"

    return expression


# 计算表达式的答案
def calculate_answer(expression):
    try:
        # 使用 eval 前先移除多余的字符，例如题号
        answer = eval(expression)
        return str(Fraction(answer).limit_denominator())
    except ZeroDivisionError:
        return "undefined"
    except Exception as e:
        return f"Error: {e}"


# 判定答案对错
def check_answers(exercise_file, answer_file):
    with open(exercise_file, "r") as ef, open(answer_file, "r") as af, open("Grade.txt", "w") as grade_file:
        correct = []
        wrong = []
        exercises = ef.readlines()
        answers = af.readlines()

        for i in range(len(exercises)):
            # 提取题目中的表达式部分，去掉题号和等号
            exercise = exercises[i].split('=')[0].split('. ')[1].strip()
            expected_answer = calculate_answer(exercise)
            given_answer = answers[i].split(". ")[1].strip()

            if expected_answer == given_answer:
                correct.append(i + 1)
            else:
                wrong.append(i + 1)

        grade_file.write(f"Correct: {len(correct)} ({', '.join(map(str, correct))})\n")
        grade_file.write(f"Wrong: {len(wrong)} ({', '.join(map(str, wrong))})\n")


# 生成题目文件和答案文件
def generate_exercises_and_answers(n, range_value):
    with open("Exercises.txt", "w") as exercise_file, open("Answers.txt", "w") as answer_file:
        for i in range(1, n + 1):
            question = generate_question(range_value)
            answer = calculate_answer(question)
            exercise_file.write(f"{i}. {question} =\n")
            answer_file.write(f"{i}. {answer}\n")


# 解析命令行参数
def main():
    parser = argparse.ArgumentParser(description="四则运算生成器")
    parser.add_argument("-n", type=int, help="生成题目的个数")
    parser.add_argument("-r", type=int, help="题目中数值的范围")
    parser.add_argument("-e", type=str, help="题目文件路径")
    parser.add_argument("-a", type=str, help="答案文件路径")

    args = parser.parse_args()

    # 检查输入参数并调用对应功能
    if args.n is not None and args.r is not None:
        generate_exercises_and_answers(args.n, args.r)
        print(f"生成了 {args.n} 道题目，数值范围为 0 到 {args.r}")
    elif args.e and args.a:
        check_answers(args.e, args.a)
        print(f"判定答案对错，结果已存入 Grade.txt 文件。")
    else:
        parser.print_help()


if __name__ == "__main__":
    main()
