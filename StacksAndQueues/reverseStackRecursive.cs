 private static Stack<int> ReverseStack(Stack<int> input)
 {
    if (input == null)
    {
        throw new ArgumentNullException("input");
    }
    else if (input.Count < 2)
    {
      return input;
    }

    // Swap the first two;
    for (int i = 0; i < input.Count - 2; i++)
    {
        int first = input.Pop();
        int second = input.Pop();
        input.Push(first);
        input = SwapAndRecurse(input, i);
        input.Push(second);
    }

    int first2 = input.Pop();
    int second2 = input.Pop();
    input.Push(first2);
    input.Push(second2);

    return input;
 }

 private static Stack<int> SwapAndRecurse(Stack<int> input, int levelToStop)
 {
    if (input.Count < levelToStop + 2)
    {
        return input;
    }

    int first = input.Pop();
    int second = input.Pop();

    input.Push(first);

    input = SwapAndRecurse(input, levelToStop);
    input.Push(second);

    return input;
 }
